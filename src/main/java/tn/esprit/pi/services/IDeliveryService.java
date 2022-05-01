package tn.esprit.pi.services;

import java.util.List;
import tn.esprit.pi.entities.Delivery;

public interface IDeliveryService {
    List<Delivery> retrieveAll();
	Delivery retrieveById(Long id_delivery);
    public Delivery addDelivery(Delivery dl);
    public Delivery updateDelivery(Delivery dl);
    public void deleteDelivery(Long id_delivery);
}
