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

import tn.esprit.pi.entities.Problems;
import tn.esprit.pi.services.IProblemsServices;



@RestController 
@RequestMapping("problemsController")
public class ProblemsController {
	
	@Autowired
	IProblemsServices problemsServices;
	
	@GetMapping("/afficherProblems")
	@ResponseBody 
	List<Problems> afficherProblems(){
	return problemsServices.retrieveAll();
	}
	
	
	@GetMapping("/afficherProblem/{id}")
	@ResponseBody 
	Problems afficherProblem(@PathVariable("id")Long id) {
	return problemsServices.retrieveById(id);
	}
	
	@PostMapping("/ajouterProblem/{iduser}")
	@ResponseBody
	Problems ajouterProblem(@RequestBody Problems p,@PathVariable("iduser")Long idUser) {
	return problemsServices.save(p,idUser);
	}
	
	@PutMapping("/updateProblem")
	@ResponseBody
	Problems updateProblem(@RequestBody Problems p) { 
	return problemsServices.update(p);
	}
	
	@DeleteMapping("/deleteProblem/{id}")
	@ResponseBody
	void supprimerProblem(@PathVariable("id") Long id) {
	problemsServices.delete(id);
	}
}
