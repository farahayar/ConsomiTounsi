package tn.esprit.pi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.pi.entities.Tags;
import tn.esprit.pi.repository.TagsRepository;

@Service
@Slf4j
public class TagsServices implements ITagsServices{
	
	@Autowired
	TagsRepository tagsRepository;
	
	@Override
	public List<Tags> retrieveAll() {
		return (List<Tags>) tagsRepository.findAll();
	}

	@Override
	public Tags retrieveById(Long id) {
		return (Tags) tagsRepository.findById(id).orElse(null);
	}

	@Override
	public Tags save(Tags t) {
		return (Tags)tagsRepository.save(t);
	}

	@Override
	public Tags update(Tags t) {
		return (Tags) tagsRepository.save(t);
	}

	@Override
	public void delete(Long id) {
		tagsRepository.deleteById(id);
	}

}
