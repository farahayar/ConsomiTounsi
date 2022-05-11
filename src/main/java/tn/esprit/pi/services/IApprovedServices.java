package tn.esprit.pi.services;

import java.util.List;

import tn.esprit.pi.entities.Approved;
import tn.esprit.pi.entities.Problems;

public interface IApprovedServices {

	List<Approved> retrieveAll();
	Approved retrieveById(Long id);
	Problems save(Approved t,Long idUser, Long idProb);
	Approved update(Approved t);
	void delete(Long id);
	Problems unApprove(Long idUser, Long idProb);
}
