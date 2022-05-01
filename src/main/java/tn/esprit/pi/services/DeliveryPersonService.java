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
	public DeliveryPerson retrieveById(Long id_deliveryp) {
		return (DeliveryPerson) deliveryPersonRepository.findById(id_deliveryp).orElse(null);
	}

    @Override
	public DeliveryPerson addDeliveryPerson(DeliveryPerson dlp) {
		return deliveryPersonRepository.save(dlp);
	}

	@Override
	public DeliveryPerson updateDeliveryPerson(DeliveryPerson dlp) {
		return deliveryPersonRepository.save(dlp);
	}

	@Override
	public void deleteDeliveryPerson(Long id_deliveryp) {
		deliveryPersonRepository.deleteById(id_deliveryp);
		
	}
}
