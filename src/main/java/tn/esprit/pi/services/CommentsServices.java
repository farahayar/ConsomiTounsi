package tn.esprit.pi.services;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.pi.entities.Comments;
import tn.esprit.pi.entities.Problems;
import tn.esprit.pi.entities.Products;
import tn.esprit.pi.entities.User;
import tn.esprit.pi.repository.CommentsRepository;
import tn.esprit.pi.repository.ProblemsRepository;
import tn.esprit.pi.repository.ProductsRepository;
import tn.esprit.pi.repository.UserRepository;

@Service
@Slf4j
public class CommentsServices implements ICommentsServices {

	@Autowired
	CommentsRepository commentsRepository;

	@Autowired
	UserRepository userRepository;
	@Autowired
	ProblemsRepository problemsRepository;

	@Autowired
	ProductsRepository productsRepository;

	@Override
	public List<Comments> retrieveAll() {
		return (List<Comments>) commentsRepository.findAll();
	}

	@Override
	public Comments retrieveById(Long id) {
		return (Comments) commentsRepository.findById(id).orElse(null);
	}

	@Override
	public Comments save(Comments t, Long id, String on, Long idUser) {
		User u = userRepository.findById(idUser).orElse(null);
		Object p;
		if (on == "product") {
			p = productsRepository.findById(id).orElse(null);
			t.setProduct((Products) p);
		} else {
			p = problemsRepository.findById(id).orElse(null);
			t.setProblem((Problems) p);
		}
		if (u == null) {
			log.warn("user n'existe pas!");
			return null;
		} else if (p == null) {
			log.warn("sujet n'existe pas!");
			return null;
		}
		t.setUser(u);
		return (Comments) commentsRepository.save(t);
	}

	@Override
	public Comments update(Comments t) {
		return (Comments) commentsRepository.save(t);
	}

	@Override
	public void delete(Long id) {
		commentsRepository.deleteById(id);

	}

	@Scheduled(fixedRate = 60000)
	public void closeProblemAfterfiftyComments() {
		

		List<Problems> ps = problemsRepository.findByClosed(false);
		for (Problems problems : ps) {
			Set<Comments> cs=(Set<Comments>) problems.getComments();
			for (Comments comments : cs) {
				if (comments.getApproved()>=50) {
					log.info("in " + comments.getApproved());
					problems.setClosed(true);
					problemsRepository.save(problems);
					break;
				}
			}
			
		}
	}

	@Override
	public List<Comments> addApprove(Long id) {
		Comments c=commentsRepository.findById(id).orElse(null);
		c.setApproved(c.getApproved()+1);
		commentsRepository.save(c);
		return commentsRepository.findAll();
	}

}
