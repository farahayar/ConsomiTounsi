package tn.esprit.pi.services;

import java.util.List;

import tn.esprit.pi.entities.ProductCategory;
import tn.esprit.pi.entities.TargetMarket;

public interface ITargetMarketService {
	List<TargetMarket> retrieveTargetMarket(); 
	TargetMarket retrieveTargetMarketById(Long idTarget);
	TargetMarket saveTargetMarket(TargetMarket tm);
	TargetMarket updateTargetMarket(TargetMarket tm); 
	void deleteTargetMarket(Long idTarget);

}
