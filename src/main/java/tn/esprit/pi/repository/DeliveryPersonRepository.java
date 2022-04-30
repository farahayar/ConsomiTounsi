package tn.esprit.pi.repository;
import tn.esprit.pi.entities.DeliveryPerson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface DeliveryPersonRepository extends JpaRepository<DeliveryPerson, Long> {
    
}
