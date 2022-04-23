package tn.esprit.pi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
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

import tn.esprit.pi.entities.Chats;
import tn.esprit.pi.services.IChatServices;


@RestController 
@RequestMapping("chatsController")
@CrossOrigin(origins = "*")
public class ChatsController {
	
	@Autowired
	IChatServices chatServices;
	
	@Autowired
	private SimpMessagingTemplate simpMessagingTemplate;

	@PostMapping("/sendMessage")
	private void sendNotif(@RequestBody Chats chat){
		simpMessagingTemplate.convertAndSend("/chat/" + chat.getReciver().getUserid(), chat);
	}
	
	@GetMapping("/afficherChats")
	@ResponseBody 
	List<Chats> afficherChatss(){
	return chatServices.retrieveAll();
	}
	
	
	@GetMapping("/afficherChat/{id}")
	@ResponseBody 
	Chats afficherChat(@PathVariable("id")Long id) {
	return chatServices.retrieveById(id);
	}
	
	@PostMapping("/ajouterChat")
	@ResponseBody
	Chats ajouterChat(@RequestBody Chats p) {
	return chatServices.save(p);
	}
	
	@PutMapping("/updateChat")
	@ResponseBody
	Chats updateChat(@RequestBody Chats p) { 
	return chatServices.update(p);
	}
	
	@DeleteMapping("/deleteChat/{id}")
	@ResponseBody
	void supprimerChat(@PathVariable("id") Long id) {
		chatServices.delete(id);
	}
}
