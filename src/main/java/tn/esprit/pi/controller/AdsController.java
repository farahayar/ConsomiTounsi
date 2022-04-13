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

import tn.esprit.pi.entities.Ads;
import tn.esprit.pi.entities.Products;
import tn.esprit.pi.services.IAdsService;

@RestController 
public class AdsController {
	@Autowired
	IAdsService adsService;
	
	@GetMapping("/afficherAds")
	@ResponseBody //pour afficher resultat
	List<Ads> afficherAllAds(){
		return adsService.retrieveAds();
	}
	
	
	@GetMapping("/afficherAd/{id}")
	@ResponseBody //pour afficher resultat
	Ads afficherAds(@PathVariable("idAds")Long idAds) {
		return adsService.retrieveAdsById(idAds);
	}
	@GetMapping("/afficherAd")
	@ResponseBody //pour afficher resultat
	Ads afficherAds2(@RequestParam("idAds")Long idAds) {
		return adsService.retrieveAdsById(idAds);
	}
	
	
	@PostMapping("/ajouterAds")
	@ResponseBody
	Ads ajouterAds(@RequestBody Ads ad) { //yaani bch naadih fl body les info
		
		return adsService.saveAds(ad);
	}
	
	@PostMapping("/ajouterAds2")
	@ResponseBody
	Ads ajouterAds2(@RequestParam Ads ad) { //yaani bch naadih fl body les info
		return adsService.saveAds(ad);
	}
	
	
	@PutMapping("/updateAds")
	@ResponseBody
	Ads updateAds(@RequestBody Ads ad) { //yaani bch naadih fl body les info nzid nes2el farah
		return adsService.updateAds(ad);
	}
	
	@DeleteMapping("/deleteAds/{id}")
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
