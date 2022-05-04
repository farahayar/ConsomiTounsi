package tn.esprit.pi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.pi.entities.Delivery;

@Repository
public interface DeliveryRepository extends JpaRepository<Delivery, Long> {
    
}
