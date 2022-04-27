package tn.esprit.pi.services;

import java.util.List;

import tn.esprit.pi.entities.Approved;

public interface IApprovedServices {

	List<Approved> retrieveAll();
	Approved retrieveById(Long id);
	Approved save(Approved t,Long idUser, Long idProb);
	Approved update(Approved t);
	void delete(Long id);
}
