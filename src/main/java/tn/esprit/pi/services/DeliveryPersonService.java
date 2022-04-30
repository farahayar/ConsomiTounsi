package tn.esprit.pi.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.pi.repository.DeliveryPersonRepository;
import tn.esprit.pi.entities.DeliveryPerson;
@Service
public class DeliveryPersonService implements IDeliveryPersonService{
    @Autowired
	DeliveryPersonRepository deliveryPersonRepository;
	
	@Override
	public List<DeliveryPerson> retrieveAll() {
		return (List<DeliveryPerson>)deliveryPersonRepository.findAll();
	}

	@Override
	public DeliveryPerson retrieveById(Long idDeliveryPerson) {
		return (DeliveryPerson) deliveryPersonRepository.findById(idDeliveryPerson).orElse(null);
	}

    @Override
	public DeliveryPerson addDeliveryPerson(DeliveryPerson dlp) {
		return deliveryPersonRepository.save(dlp);
	}
}
