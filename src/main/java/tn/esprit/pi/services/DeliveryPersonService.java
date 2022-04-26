package tn.esprit.pi.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.pi.repository.DeliveryPersonRepository;
import tn.esprit.pi.entities.DeliveryPerson;
@Service
public class DeliveryPersonService implements IDeliveryPersonService{
    @Autowired
	DeliveryPersonRepository deliverypersonRepository;
	
	public DeliveryPerson addDelivery(DeliveryPerson dlp) {
		return deliverypersonRepository.save(dlp);
	}
}
