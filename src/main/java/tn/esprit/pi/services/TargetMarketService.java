package tn.esprit.pi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.pi.entities.Products;
import tn.esprit.pi.entities.TargetMarket;
import tn.esprit.pi.repository.TargetMarketRepository;
@Service
public class TargetMarketService implements ITargetMarketService {
	@Autowired
	TargetMarketRepository targetMarketRepository;

	@Override
	public List<TargetMarket> retrieveTargetMarket() {
		return (List<TargetMarket>) targetMarketRepository.findAll();
	}

	@Override
	public TargetMarket retrieveTargetMarketById(Long idTarget) {
		return targetMarketRepository.findById(idTarget).orElse(null);
	}

	@Override
	public TargetMarket saveTargetMarket(TargetMarket tm) {
		
		return targetMarketRepository.save(tm);
	}

	@Override
	public TargetMarket updateTargetMarket(TargetMarket tm) {
		// TODO Auto-generated method stub
		return targetMarketRepository.save(tm);
	}

	@Override
	public void deleteTargetMarket(Long idTarget) {
		 targetMarketRepository.deleteById(idTarget);;
		
	}

}
