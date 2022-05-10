package tn.esprit.pi.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import tn.esprit.pi.entities.Bills;
import tn.esprit.pi.entities.User;


public interface BillsRepository extends JpaRepository<Bills, Long> {
	
	   List<Bills> findBillsByUser(User user);


	    @Query(value = "SELECT f FROM Bills f WHERE f.user.idUser = ?1")
	    List<Bills> findFacturesByUser(Long idClient);
	}


