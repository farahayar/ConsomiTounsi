package tn.esprit.pi.services;

import tn.esprit.pi.entities.Ads;
import tn.esprit.pi.entities.Rating;

public interface IRatingService {
	Rating saveRating(Rating ra, Long userid, Long idProd);

}
