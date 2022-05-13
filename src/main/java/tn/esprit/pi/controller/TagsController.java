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

import tn.esprit.pi.entities.Tags;
import tn.esprit.pi.services.ITagsServices;



@RestController 
@RequestMapping("tagsController")
public class TagsController {
	
	@Autowired
	ITagsServices tagsServices;
	
	@GetMapping("/afficherTags")
	@ResponseBody 
	List<Tags> afficherTagss(){
	return tagsServices.retrieveAll();
	}
	
	
	@GetMapping("/afficherTag/{id}")
	@ResponseBody 
	Tags afficherTag(@PathVariable("id")Long id) {
	return tagsServices.retrieveById(id);
	}
	
	@PostMapping("/ajouterTag")
	@ResponseBody
	Tags ajouterTag(@RequestBody Tags p) {
	return tagsServices.save(p);
	}
	
	@PutMapping("/updateTag")
	@ResponseBody
	Tags updateTag(@RequestBody Tags p) { 
	return tagsServices.update(p);
	}
	
	@DeleteMapping("/deleteTag/{id}")
	@ResponseBody
	void supprimerTag(@PathVariable("id") Long id) {
	tagsServices.delete(id);
	}
}
