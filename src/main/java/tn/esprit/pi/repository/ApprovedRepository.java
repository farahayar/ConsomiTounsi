package tn.esprit.pi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.pi.entities.Approved;
import tn.esprit.pi.entities.Problems;
import tn.esprit.pi.entities.User;

@Repository
public interface ApprovedRepository extends JpaRepository<Approved, Long>{

	Approved findByUserAndProblem(User u, Problems p);
}
