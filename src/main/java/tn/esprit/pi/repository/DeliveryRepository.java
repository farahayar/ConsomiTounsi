package tn.esprit.pi.repository;

import tn.esprit.pi.entities.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface DeliveryRepository extends JpaRepository<Delivery, Long> {
    
}
