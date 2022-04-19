package tn.esprit.pi.services;

import java.util.List;

import tn.esprit.pi.entities.Chats;

public interface IChatServices {
	List<Chats> retrieveAll();
	Chats retrieveById(Long id);
	Chats save(Chats t);
	Chats update(Chats t);
	void delete(Long id);

}
