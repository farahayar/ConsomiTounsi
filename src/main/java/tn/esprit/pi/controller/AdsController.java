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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.pi.entities.Ads;
import tn.esprit.pi.entities.Products;
import tn.esprit.pi.services.IAdsService;
@CrossOrigin(origins = "*")
@RestController 
public class AdsController {
	@Autowired
	IAdsService adsService;
	
	@GetMapping("/afficherAds")
	@ResponseBody 
	List<Ads> afficherAllAds(){
		return adsService.retrieveAds();
	}
	
	
	@GetMapping("/afficherAd/{id}")
	@ResponseBody 
	Ads afficherAds(@PathVariable("idAds")Long idAds) {
		return adsService.retrieveAdsById(idAds);
	}
	@GetMapping("/afficherAd")
	@ResponseBody 
	Ads afficherAds2(@RequestParam("idAds")Long idAds) {
		return adsService.retrieveAdsById(idAds);
	}
	
	
	@PostMapping("/ajouterAds")
	@ResponseBody
	Ads ajouterAds(@RequestBody Ads ad) { 
		
		return adsService.saveAds(ad);
	}
	
	@PostMapping("/ajouterAds2")
	@ResponseBody
	Ads ajouterAds2(@RequestParam Ads ad) { 
		return adsService.saveAds(ad);
	}
	
	
	@PutMapping("/updateAds")
	@ResponseBody
	Ads updateAds(@RequestBody Ads ad) { 
		return adsService.updateAds(ad);
	}
	
	@DeleteMapping("/deleteAds/{idAds}")
	@ResponseBody
	void supprimerAds(@PathVariable("idAds") Long idAds) {
		adsService.deleteAds(idAds);
	}
	
	@DeleteMapping("/deleteAds2")
	@ResponseBody
	void supprimerAds2(@RequestParam("idAds") Long idAds) {
		adsService.deleteAds(idAds);
	}
	

}
