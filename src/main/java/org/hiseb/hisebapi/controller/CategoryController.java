package org.hiseb.hisebapi.controller;

import java.util.List;

import org.hiseb.hisebapi.entity.Category;
import org.hiseb.hisebapi.model.ApiError;
import org.hiseb.hisebapi.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categories")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;

	@GetMapping("")
	ResponseEntity<Object> getAll() {
		try {
			List<Category> list = this.categoryService.read();
			return ResponseEntity.ok().body(list);
		} catch (Exception e) {
			return ResponseEntity.internalServerError()
					.body(new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage()));
		}
	}

	@PostMapping("")
	ResponseEntity<Object> save(@RequestBody Category category) {
		try {
			this.categoryService.create(category);
			return ResponseEntity.ok().body(HttpStatus.OK);
		} catch (DataIntegrityViolationException e) {
			return ResponseEntity.internalServerError().body(new ApiError(HttpStatus.INTERNAL_SERVER_ERROR,
					"Either Label or Background and Font already exists"));
		}
	}

	@PutMapping("/{id}")
	ResponseEntity<Object> update(@PathVariable(name = "id") long id, @RequestBody Category category) throws Exception {
		try {
			this.categoryService.update(id, category);
			return ResponseEntity.ok().body(HttpStatus.OK);
		} catch (DataIntegrityViolationException e) {
			return ResponseEntity.internalServerError().body(new ApiError(HttpStatus.INTERNAL_SERVER_ERROR,
					"Either Label or Background and Font already exists"));
		}
	}

	@DeleteMapping("/{id}")
	ResponseEntity<Object> update(@PathVariable(name = "id") long id) throws Exception {
		try {
			this.categoryService.delete(id);
			return ResponseEntity.ok().body(HttpStatus.OK);
		} catch (Exception e) {
			return ResponseEntity.internalServerError()
					.body(new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage()));
		}
	}

	@GetMapping("/health")
	HttpStatus health() {
		return HttpStatus.OK;
	}

}
