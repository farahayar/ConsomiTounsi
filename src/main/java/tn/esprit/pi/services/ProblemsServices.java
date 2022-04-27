package tn.esprit.pi.services;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.swagger.annotations.Info;
import lombok.extern.slf4j.Slf4j;
import tn.esprit.pi.entities.Problems;
import tn.esprit.pi.entities.User;
import tn.esprit.pi.repository.ProblemsRepository;
import tn.esprit.pi.repository.UserRepository;

@Service
@Slf4j
public class ProblemsServices implements IProblemsServices{
	
	@Autowired
	ProblemsRepository problemsRepository; 
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public List<Problems> retrieveAll() {
		
		return (List<Problems>) problemsRepository.findAll();
	}

	@Override
	public Problems retrieveById(Long id) {
		return (Problems) problemsRepository.findById(id).get();
	}

	@Override
	public Problems save(Problems p, Long idUser) {
		User u =(User)userRepository.findById(idUser).get();
		Set<Problems> ps = u.getProblems();
		p.setUser(u);
		ps.add(p);
		return (Problems) problemsRepository.save(p);
	}
	
		

	@Override
	public Problems update(Problems p) {
		return (Problems) problemsRepository.save(p);
	}

	//Todo 
	@Override
	public void delete(Long id) {
		problemsRepository.deleteById(id);
		
	}

}
