package tn.esprit.pi.services;

import java.util.List;

import tn.esprit.pi.entities.Comments;

public interface ICommentsServices {
	
	List<Comments> retrieveAll();
	Comments retrieveById(Long id);
	Comments save(Comments t,Long id, String on,Long idUser);
	Comments update(Comments t);
	void delete(Long id);
	List<Comments> addApprove(Long id);

}
