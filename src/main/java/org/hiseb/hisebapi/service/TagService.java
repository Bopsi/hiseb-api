package org.hiseb.hisebapi.service;

import java.util.List;

import org.hiseb.hisebapi.model.Tag;
import org.hiseb.hisebapi.repo.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TagService {
	
	@Autowired
	private TagRepository tagRepository;

	public void create(Tag tag) {
		this.tagRepository.save(tag);
	}

	public List<Tag> read() {
		return (List<Tag>) this.tagRepository.findAll();
	}

	public void update(long id, Tag tag) throws Exception {
		Tag _tag = this.tagRepository.findById(id).get();
		if (_tag != null) {
			this.tagRepository.save(tag);
		} else {
			throw new Exception("Tag does not exist");
		}
	}

	public void delete(long id) throws Exception {
		Tag _tag = this.tagRepository.findById(id).get();
		if (_tag != null) {
			this.tagRepository.deleteById(id);
		} else {
			throw new Exception("Tag does not exist");
		}
	}
}
