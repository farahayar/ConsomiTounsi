package tn.esprit.pi.services;

import java.util.List;

import tn.esprit.pi.entities.DeliveryPerson;

public interface IDeliveryPersonService {
    List<DeliveryPerson> retrieveAll();
	DeliveryPerson retrieveById(Long id_deliveryp);
    public DeliveryPerson addDeliveryPerson(DeliveryPerson dlp);
    public DeliveryPerson updateDeliveryPerson(DeliveryPerson dlp);
    public void deleteDeliveryPerson(Long id_deliveryp);
}
