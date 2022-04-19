package tn.esprit.pi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.pi.entities.Userf;

@Repository
public interface UserfRepository extends JpaRepository<Userf, Long> {

}
