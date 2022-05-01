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
	public Delivery retrieveById(Long id_delivery) {
		return (Delivery) deliveryRepository.findById(id_delivery).orElse(null);
	}

    @Override
	public Delivery addDelivery(Delivery dl) {
		return deliveryRepository.save(dl);
	}

	@Override
	public Delivery updateDelivery(Delivery dl) {
		return deliveryRepository.save(dl);
	}

	@Override
	public void deleteDelivery(Long id_delivery) {
		deliveryRepository.deleteById(id_delivery);
		
	}

}
