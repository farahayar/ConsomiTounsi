package tn.esprit.pi.services;

import java.util.List;

import tn.esprit.pi.entities.Problems;


public interface IProblemsServices {
	List<Problems> retrieveAll();
	Problems retrieveById(Long id);
	Problems save(Problems p);
	Problems update(Problems p);
	void delete(Long id);

}
