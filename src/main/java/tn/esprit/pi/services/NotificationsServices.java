package tn.esprit.pi.services;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.pi.entities.Notifications;
import tn.esprit.pi.repository.NotificationsRepository;
import tn.esprit.pi.repository.ProblemsRepository;
import tn.esprit.pi.repository.UserfRepository;

@Service
@Slf4j
public class NotificationsServices implements INotificationsServices{
	
	
	@Autowired
	NotificationsRepository notificationsRepository;
	
	@Autowired
	UserfRepository userfRepository;
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

	@Override
	public Notifications save(Notifications t) {
		Set<Notifications> ns= t.getUser().getNotifications();
		ns.add(t);
		userfRepository.save(t.getUser());
		ns= t.getProblem().getNotifications();
		ns.add(t);
		problemsRepository.save(t.getProblem());
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
