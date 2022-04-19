package tn.esprit.pi.services;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.pi.entities.Problems;
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
		return (Problems) problemsRepository.findById(id).orElse(null);
	}

	@Override
	public Problems save(Problems p) {
		Set<Problems> ps=p.getUser().getProblems();
		ps.add(p);
		userRepository.save(p.getUser());
		return (Problems) problemsRepository.save(p);
	}
	

	@Override
	public Problems update(Problems p) {
		return (Problems) problemsRepository.save(p);
	}

	@Override
	public void delete(Long id) {
		problemsRepository.deleteById(id);
		
	}

}
