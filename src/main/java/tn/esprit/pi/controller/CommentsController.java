package tn.esprit.pi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import tn.esprit.pi.entities.Comments;
import tn.esprit.pi.services.ICommentsServices;



@RestController 
@RequestMapping("commentsController")
@CrossOrigin(origins = "*")
public class CommentsController {
	
	@Autowired
	ICommentsServices commentsServices;
	
	@GetMapping("/afficherComments")
	@ResponseBody 
	List<Comments> afficherComments(){
	return commentsServices.retrieveAll();
	}
	
	
	@GetMapping("/afficherComment/{id}")
	@ResponseBody 
	Comments afficherComment(@PathVariable("id")Long id) {
	return commentsServices.retrieveById(id);
	}
	
	@PostMapping("/ajouterComment/{id}/{idUser}/{on}")
	@ResponseBody
	Comments ajouterComment(@RequestBody Comments c,@PathVariable("id") Long id,@PathVariable("on") String on,@PathVariable("idUser")Long idUser) {
	return commentsServices.save(c, id, on,idUser);
	}
	
	@PutMapping("/updateComment")
	@ResponseBody
	Comments updateComment(@RequestBody Comments p) { 
	return commentsServices.update(p);
	}
	
	@DeleteMapping("/deleteComment/{id}")
	@ResponseBody
	void supprimerComment(@PathVariable("id") Long id) {
	commentsServices.delete(id);
	}
	
	@GetMapping("/addApprove/{id}")
	@ResponseBody
	List<Comments> addApprove(@PathVariable("id") Long id) {
	return commentsServices.addApprove(id);
	}
}
