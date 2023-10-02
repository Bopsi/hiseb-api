package org.hiseb.hisebapi.controller;

import java.util.List;

import org.hiseb.hisebapi.model.Tag;
import org.hiseb.hisebapi.service.TagService;
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
@RequestMapping("/tags")
public class TagController {
	
	@Autowired
	private TagService tagService;

	@GetMapping("/all")
	List<Tag> getAll() {
		return this.tagService.read();
	}
	
	@PostMapping("/")
	void save(@RequestBody Tag tag) {
		this.tagService.create(tag);
	}

	@PutMapping("/:id")
	void update(@PathVariable(name = "id") long id, @RequestBody Tag tag) throws Exception {
		this.tagService.update(id, tag);
	}

	@DeleteMapping("/:id")
	void update(@PathVariable(name = "id") long id) throws Exception {
		this.tagService.delete(id);
	}
	
	@GetMapping("/test")
	HttpStatus health() {
		return HttpStatus.OK;
	}
}
