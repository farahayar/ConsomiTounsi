package tn.esprit.pi.services;

import java.util.List;

import tn.esprit.pi.entities.Tags;


public interface ITagsServices {
	
	List<Tags> retrieveAll();
	Tags retrieveById(Long id);
	Tags save(Tags t);
	Tags update(Tags t);
	void delete(Long id);

}
