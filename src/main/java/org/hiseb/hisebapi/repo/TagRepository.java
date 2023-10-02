package org.hiseb.hisebapi.repo;

import org.hiseb.hisebapi.entity.Tag;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends CrudRepository<Tag, Long> {
	
}

