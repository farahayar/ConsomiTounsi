package tn.esprit.pi.services;

import java.util.List;
import tn.esprit.pi.entities.Delivery;

public interface IDeliveryService {
    List<Delivery> retrieveAll();
	Delivery retrieveById(Long idDelivery);
    public Delivery addDelivery(Delivery dl);
}
