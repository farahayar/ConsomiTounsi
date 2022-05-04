package tn.esprit.pi.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.pi.entities.DeliveryPerson;
import tn.esprit.pi.repository.DeliveryPersonRepository;

@Service
public class DeliveryPersonService implements IDeliveryPersonService{
    
	@Autowired
	DeliveryPersonRepository deliverypersonRepository;
	
	@Override
	public DeliveryPerson addDeliveryPerson(DeliveryPerson dlp) {
		return deliverypersonRepository.save(dlp);
	}
}
