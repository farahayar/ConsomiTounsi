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

import tn.esprit.pi.entities.Approved;
import tn.esprit.pi.services.IApprovedServices;



@RestController 
@RequestMapping("likesController")
public class ApprovedController {
	
	@Autowired
	IApprovedServices likesServices;
	
	@GetMapping("/afficherlikes")
	@ResponseBody 
	List<Approved> afficherLikes(){
	return likesServices.retrieveAll();
	}
	
	
	@GetMapping("/afficherlike/{id}")
	@ResponseBody 
	Approved afficherlike(@PathVariable("id")Long id) {
	return likesServices.retrieveById(id);
	}
	
	@PostMapping("/ajouterlike")
	@ResponseBody
	Approved ajouterlike(@RequestBody Approved p) {
	return likesServices.save(p);
	}
	
	@PutMapping("/updatelike")
	@ResponseBody
	Approved updatelike(@RequestBody Approved p) { 
	return likesServices.update(p);
	}
	
	@DeleteMapping("/deletelike/{id}")
	@ResponseBody
	void supprimerlike(@PathVariable("id") Long id) {
	likesServices.delete(id);
	}
}
