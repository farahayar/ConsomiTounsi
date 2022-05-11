package tn.esprit.pi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.pi.entities.Products;
import tn.esprit.pi.entities.Rating;
import tn.esprit.pi.entities.User;
import tn.esprit.pi.repository.ProductsRepository;
import tn.esprit.pi.repository.RatingRepository;
import tn.esprit.pi.repository.UserRepository;
@Service
public class RatingService implements IRatingService {
	@Autowired
	RatingRepository ratingRepository;
	@Autowired
	ProductsRepository productsRepository;
	@Autowired
	UserRepository userRepository;
	


	@Override
	public Rating saveRating(Rating ra, Long userid, Long idProd) {
		User u = userRepository.findById(userid).orElse(null);
		Products p = productsRepository.findById(idProd).orElse(null);
		ra.setUserrating(u);
		ra.setProductsrating(p);
		
	
		// TODO Auto-generated method stub
		return ratingRepository.save(ra) ;
	}
	}
	
	
