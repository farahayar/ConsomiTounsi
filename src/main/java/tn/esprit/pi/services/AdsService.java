package tn.esprit.pi.services;

import java.util.List;
import java.util.Optional;

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
		
		return  adsRepository.findAll();
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
		Ads ads = adsRepository.findById(ad.getIdAds()).get();
		ads.setNameAds(ad.getNameAds());
		ads.setChannel(ad.getChannel());
		ads.setStart_date(ad.getStart_date());
		ads.setFinal_date(ad.getFinal_date());
		ads.setNb_initial_views(ad.getNb_initial_views());
		ads.setNb_final_views(ad.getNb_final_views());
		ads.setCost(ad.getCost());
		ads.setType_ads(ad.getType_ads());
		ads.setProducts(ad.getProducts());
		return adsRepository.save(ads);
	}

	@Override
	public void deleteAds(Long idAds) {
		Optional<Ads> ads = adsRepository.findById(idAds);
		if(ads.isPresent()){
		adsRepository.deleteById(idAds);
		}else{
			System.out.println("No Ad record exist for given id");
		}
		
	}

}
