package tn.esprit.pi.services;

import java.util.List;

import tn.esprit.pi.entities.Notifications;

public interface INotificationsServices {

	List<Notifications> retrieveAll();
	Notifications retrieveById(Long id);
	Notifications save(Notifications t);
	Notifications update(Notifications t);
	void delete(Long id);
}
