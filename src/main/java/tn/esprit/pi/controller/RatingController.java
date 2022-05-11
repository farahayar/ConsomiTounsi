package tn.esprit.pi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.pi.entities.Ads;
import tn.esprit.pi.entities.Rating;
import tn.esprit.pi.services.IRatingService;
import tn.esprit.pi.services.RatingService;

@CrossOrigin(origins = "*")
@RestController 
public class RatingController {
	@Autowired
	IRatingService ratingService;
	
	@PostMapping("/ajouterRating/{userid}/{idProd}")
	@ResponseBody
	Rating ajouterAds(@RequestBody Rating ra, @PathVariable Long  userid,@PathVariable Long idProd) { 
		
		return ratingService.saveRating(ra,userid,idProd);
	}

}
