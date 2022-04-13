package tn.esprit.pi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.pi.entities.Products;
import tn.esprit.pi.entities.TargetMarket;
import tn.esprit.pi.services.IProductsService;
import tn.esprit.pi.services.ITargetMarketService;

@RestController 
public class TargetMarketController {
	@Autowired 
	ITargetMarketService targetMarketService;
	
	@GetMapping("/afficherTms")
	@ResponseBody //pour afficher resultat
	List<TargetMarket> afficherAllTm(){
		return targetMarketService.retrieveTargetMarket();
	}
	
	
	@GetMapping("/afficherTm/{id}")
	@ResponseBody //pour afficher resultat
	TargetMarket afficherTm(@PathVariable("idTarget")Long idTarget) {
		return targetMarketService.retrieveTargetMarketById(idTarget);
	}
	@GetMapping("/afficherTm")
	@ResponseBody //pour afficher resultat
	TargetMarket afficherTm2(@RequestParam("idTarget")Long idTarget) {
			return targetMarketService.retrieveTargetMarketById(idTarget);
	}
	
	
	@PostMapping("/ajouterTm")
	@ResponseBody
	TargetMarket ajouterTm(@RequestBody TargetMarket tm) { //yaani bch naadih fl body les info
		
		return targetMarketService.saveTargetMarket(tm);
	}
	
	@PostMapping("/ajouterTm2")
	@ResponseBody
	TargetMarket ajouterTm2(@RequestParam TargetMarket tm) { //yaani bch naadih fl body les info
		return targetMarketService.saveTargetMarket(tm);
	}
	
	
	@PutMapping("/updateTm")
	@ResponseBody
	TargetMarket updateTm(@RequestBody TargetMarket tm) { //yaani bch naadih fl body les info nzid nes2el farah
		return targetMarketService.updateTargetMarket(tm);
	}
	
	@DeleteMapping("/deleteTm/{id}")
	@ResponseBody
	void supprimerTm(@PathVariable("idTarget") Long idTarget) {
		targetMarketService.deleteTargetMarket(idTarget);
	}
	
	@DeleteMapping("/deleteTm2")
	@ResponseBody
	void supprimerTm2(@RequestParam("idTarget") Long idTarget) {
		targetMarketService.deleteTargetMarket(idTarget);
	}
	
}
