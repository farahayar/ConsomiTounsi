package tn.esprit.pi.services;

import java.util.List;

import tn.esprit.pi.entities.DeliveryPerson;

public interface IDeliveryPersonService {
    List<DeliveryPerson> retrieveAll();
	DeliveryPerson retrieveById(Long idDelivery);
    public DeliveryPerson addDeliveryPerson(DeliveryPerson dlp);
}
