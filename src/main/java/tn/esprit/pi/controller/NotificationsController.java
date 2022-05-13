package tn.esprit.pi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.pi.entities.Notifications;
import tn.esprit.pi.services.INotificationsServices;



@RestController 
@RequestMapping("notificationsController")
public class NotificationsController {
	
	@Autowired
	INotificationsServices notificationsServices;
	
	@GetMapping("/afficherNotifications")
	@ResponseBody 
	List<Notifications> afficherNotifications(){
	return notificationsServices.retrieveAll();
	}
	
	
	@GetMapping("/afficherNotification/{id}")
	@ResponseBody 
	Notifications afficherNotification(@PathVariable("id")Long id) {
	return notificationsServices.retrieveById(id);
	}
	
	@PostMapping("/ajouterNotification/{idUser}/{idProb}")
	@ResponseBody
	Notifications ajouterNotification(@RequestBody Notifications p,@PathVariable("idUser")Long idUser,@PathVariable("idProb")Long idProb) {
	return notificationsServices.save(p,idUser,idProb);
	}
	
	@PutMapping("/updateNotification")
	@ResponseBody
	Notifications updateNotification(@RequestBody Notifications p) { 
	return notificationsServices.update(p);
	}
	
	@DeleteMapping("/deleteNotification/{id}")
	@ResponseBody
	void supprimerNotification(@PathVariable("id") Long id) {
	notificationsServices.delete(id);
	}
}
