package tn.esprit.pi.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.pi.repository.DeliveryRepository;
import tn.esprit.pi.entities.Delivery;
@Service
public class DeliveryService implements IDeliveryService{
    @Autowired
	DeliveryRepository deliveryRepository;
	
    @Override
	public Delivery addDelivery(Delivery dl) {
		return deliveryRepository.save(dl);
	}
}
