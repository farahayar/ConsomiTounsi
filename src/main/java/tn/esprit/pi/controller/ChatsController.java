package tn.esprit.pi.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
	@Value("${admin.id}")
	String adminId;
	
	@Autowired
	private SimpMessagingTemplate simpMessagingTemplate;

	@PostMapping("/sendMessage")
	private void chatWithAdmin(@RequestBody Chats chat){
		if(chat.getReciver().userid==null)
			chat.getReciver().setUserid(Long.valueOf(adminId));
		chat.setDate(new Date());
		chat=chatServices.save(chat);
		simpMessagingTemplate.convertAndSend("/chat/" + chat.getReciver().getUserid(), chat);
	}
	
	@GetMapping("/afficherChats")
	@ResponseBody 
	List<Chats> afficherChatss(){
	return chatServices.retrieveAll();
	}
	
	@GetMapping("/getMessageWithAdmin/{id}")
	@ResponseBody 
	List<Chats> getMessageWithAdmin(@PathVariable("id") Long userid){
	return chatServices.getMessageWithAdmin(userid,Long.valueOf(adminId));
	}

	@GetMapping("/getAdminListChat")
	@ResponseBody 
	List<Chats> getAdminListChat(){
	return chatServices.getAdminListChat(Long.valueOf(adminId));
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
