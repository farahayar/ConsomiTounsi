package tn.esprit.pi.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.pi.entities.Delivery;
import tn.esprit.pi.repository.DeliveryRepository;
@Service
public class DeliveryService implements IDeliveryService{
    @Autowired
	DeliveryRepository deliveryRepository;
	
	@Override
	public List<Delivery> retrieveAll() {
		return (List<Delivery>)deliveryRepository.findAll();
	}

	@Override
	public Delivery retrieveById(Long idDelivery) {
		return (Delivery) deliveryRepository.findById(idDelivery).orElse(null);
	}

    @Override
	public Delivery addDelivery(Delivery dl) {
		return deliveryRepository.save(dl);
	}
}
