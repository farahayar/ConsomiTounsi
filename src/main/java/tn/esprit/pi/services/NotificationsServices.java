package tn.esprit.pi.services;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.pi.entities.Notifications;
import tn.esprit.pi.entities.Problems;
import tn.esprit.pi.entities.User;
import tn.esprit.pi.repository.NotificationsRepository;
import tn.esprit.pi.repository.ProblemsRepository;
import tn.esprit.pi.repository.UserRepository;

@Service
@Slf4j
public class NotificationsServices implements INotificationsServices{
	
	
	@Autowired
	NotificationsRepository notificationsRepository;
	
	@Autowired
	UserRepository userRepository;
	@Autowired
	ProblemsRepository problemsRepository;
	
	
	@Override
	public List<Notifications> retrieveAll() {
		return (List<Notifications>)notificationsRepository.findAll();
	}

	@Override
	public Notifications retrieveById(Long id) {
		return (Notifications) notificationsRepository.findById(id).orElse(null);
	}

	
	// w nthabet zeda el user welprobleme wein yjibhom felservice wala controller
	@Override
	public Notifications save(Notifications t,Long idUser, Long idProb) {
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
		return (Notifications) notificationsRepository.save(t);
	}

	@Override
	public Notifications update(Notifications t) {
		return (Notifications) notificationsRepository.save(t);
	}

	@Override
	public void delete(Long id) {
		notificationsRepository.deleteById(id);
		
	}

}
