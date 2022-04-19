package tn.esprit.pi.services;

import java.util.List;

import tn.esprit.pi.entities.Ads;



public interface IAdsService {
	List<Ads> retrieveAds(); 
	Ads retrieveAdsById(Long idAds);
	Ads saveAds(Ads ad);
	Ads updateAds (Ads ad); 
	void deleteAds (Long idAds);

}
