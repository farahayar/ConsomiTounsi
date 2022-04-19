package tn.esprit.pi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.pi.entities.Approved;

@Repository
public interface ApprovedRepository extends JpaRepository<Approved, Long>{

}
