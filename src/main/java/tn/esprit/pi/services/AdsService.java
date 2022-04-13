package tn.esprit.pi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.pi.entities.Ads;
import tn.esprit.pi.repository.AdsRepository;
@Service
public class AdsService implements IAdsService {
	@Autowired
	AdsRepository adsRepository;

	@Override
	public List<Ads> retrieveAds() {
		
		return (List<Ads>) adsRepository.findAll();
	}

	@Override
	public Ads retrieveAdsById(Long idAds) {
		return adsRepository.findById(idAds).orElse(null);
	}

	@Override
	public Ads saveAds(Ads ad) {
		
		return adsRepository.save(ad);
	}

	@Override
	public Ads updateAds(Ads ad) {
		return adsRepository.save(ad);
	}

	@Override
	public void deleteAds(Long idAds) {
		adsRepository.deleteById(idAds);
		
	}

}
