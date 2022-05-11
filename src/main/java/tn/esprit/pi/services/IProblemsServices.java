package tn.esprit.pi.services;

import java.util.List;
import java.util.Set;

import tn.esprit.pi.entities.Problems;
import tn.esprit.pi.entities.Tags;
import tn.esprit.pi.entities.User;


public interface IProblemsServices {
	List<Problems> retrieveAll();
	Problems retrieveById(Long id);
	addProblemResponse save(Problems p,Set<Tags> tags,Long idUser);
	Problems update(Problems p);
	void delete(Long id);
	Problems closeProblem(Long id);
	List<Problems> recently();
	

}
