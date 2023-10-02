package org.hiseb.hisebapi.service;

import java.util.List;

import org.hiseb.hisebapi.entity.Category;
import org.hiseb.hisebapi.repo.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;

	public void create(Category category) {
		this.categoryRepository.save(category);
	}

	public List<Category> read() {
		return (List<Category>) this.categoryRepository.findAll();
	}

	public void update(long id, Category category) throws Exception {
		Category _category = this.categoryRepository.findById(id).get();
		if (_category != null) {
			this.categoryRepository.save(category);
		} else {
			throw new Exception("Category does not exist");
		}
	}

	public void delete(long id) throws Exception {
		Category _category = this.categoryRepository.findById(id).get();
		if (_category != null) {
			this.categoryRepository.deleteById(id);
		} else {
			throw new Exception("Category does not exist");
		}
	}
}
