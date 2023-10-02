package org.hiseb.hisebapi.controller;

import java.util.List;

import org.hiseb.hisebapi.entity.Category;
import org.hiseb.hisebapi.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
	List<Category> getAll() {
		return this.categoryService.read();
	}
	
	@PostMapping("")
	void save(@RequestBody Category category) {
		this.categoryService.create(category);
	}

	@PutMapping("/{id}")
	void update(@PathVariable(name = "id") long id, @RequestBody Category category) throws Exception {
		this.categoryService.update(id, category);
	}

	@DeleteMapping("/{id}")
	void update(@PathVariable(name = "id") long id) throws Exception {
		this.categoryService.delete(id);
	}
	
	@GetMapping("/test")
	HttpStatus health() {
		return HttpStatus.OK;
	}
}
