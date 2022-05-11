package tn.esprit.pi.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.pi.entities.Problems;

@Repository
public interface ProblemsRepository extends JpaRepository<Problems, Long>{

	List<Problems> findByClosed(boolean b);
	List<Problems> findByDateBetween(Date d1 , Date d2);
}
