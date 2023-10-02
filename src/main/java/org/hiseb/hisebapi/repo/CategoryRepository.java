package org.hiseb.hisebapi.repo;

import org.hiseb.hisebapi.entity.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
	
}

