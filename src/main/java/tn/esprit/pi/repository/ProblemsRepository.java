package tn.esprit.pi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.pi.entities.Problems;

@Repository
public interface ProblemsRepository extends JpaRepository<Problems, Long>{

}
