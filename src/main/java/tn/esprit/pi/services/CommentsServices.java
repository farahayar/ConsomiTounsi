package tn.esprit.pi.services;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.pi.entities.Comments;
import tn.esprit.pi.repository.CommentsRepository;
import tn.esprit.pi.repository.ProblemsRepository;
import tn.esprit.pi.repository.UserRepository;
@Service
@Slf4j
public class CommentsServices implements ICommentsServices{
	
	
	@Autowired
	CommentsRepository commentsRepository;
	
	@Autowired
	UserRepository userRepository;
	@Autowired
	ProblemsRepository problemsRepository;
	
	@Override
	public List<Comments> retrieveAll() {
		return (List<Comments>)commentsRepository.findAll();
	}

	@Override
	public Comments retrieveById(Long id) {
		return (Comments) commentsRepository.findById(id).orElse(null);
	}

	@Override
	public Comments save(Comments t) {
		Set<Comments> cs= t.getUser().getComments();
		cs.add(t);
		userRepository.save(t.getUser());
		cs= t.getProblem().getComments();
		cs.add(t);
		problemsRepository.save(t.getProblem());
		
		return (Comments)commentsRepository.save(t);
	}

	@Override
	public Comments update(Comments t) {
		return (Comments)commentsRepository.save(t);
	}

	@Override
	public void delete(Long id) {
		commentsRepository.deleteById(id);
		
	}

}
