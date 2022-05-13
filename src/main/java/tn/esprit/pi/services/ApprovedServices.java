package tn.esprit.pi.services;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.swagger.v3.oas.annotations.servers.Server;
import lombok.extern.slf4j.Slf4j;
import tn.esprit.pi.entities.Approved;
import tn.esprit.pi.entities.Comments;
import tn.esprit.pi.entities.Problems;
import tn.esprit.pi.entities.User;
import tn.esprit.pi.repository.ApprovedRepository;
import tn.esprit.pi.repository.ProblemsRepository;
import tn.esprit.pi.repository.UserRepository;

@Service
@Slf4j
public class ApprovedServices implements IApprovedServices{
	
	
	@Autowired
	ApprovedRepository likesRepository; 
	

	@Autowired
	UserRepository userRepository;
	@Autowired
	ProblemsRepository problemsRepository;
	
	@Override
	public List<Approved> retrieveAll() {
		return (List<Approved>) likesRepository.findAll();
	}

	@Override
	public Approved retrieveById(Long id) {
		return (Approved)likesRepository.findById(id).orElse(null);
	}

	@Override
	public Approved save(Approved t,Long idUser, Long idProb) {
		User u=userRepository.findById(idUser).orElse(null);
		Problems p=problemsRepository.findById(idProb).orElse(null);
		if (u== null) {
			log.warn("user n'existe pas!");
			return null;
		}else if (p==null){
			log.warn("sujet n'existe pas!");
			return null;
		}
		t.setUser(u);
		t.setProblem(p);
		return (Approved)likesRepository.save(t);
	}

	@Override
	public Approved update(Approved t) {
		return (Approved)likesRepository.save(t);
	}

	@Override
	public void delete(Long id) {
		likesRepository.deleteById(id);
		
	}
	
	

}
