package tn.esprit.pi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.pi.entities.Chats;
import tn.esprit.pi.repository.ChatsRepository;

@Service
@Slf4j
public class ChatsServices implements IChatServices{
	
	@Autowired
	ChatsRepository chatsRepository;
	
	@Override
	public List<Chats> retrieveAll() {
		return (List<Chats>) chatsRepository.findAll();
	}

	@Override
	public Chats retrieveById(Long id) {
		return (Chats) chatsRepository.findById(id).orElse(null);
	}

	@Override
	public Chats save(Chats t) {
		return (Chats) chatsRepository.save(t);
	}

	@Override
	public Chats update(Chats t) {
		return (Chats)chatsRepository.save(t);
	}

	@Override
	public void delete(Long id) {
		chatsRepository.deleteById(id);
		
	}

}
