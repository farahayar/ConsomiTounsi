package tn.esprit.pi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.pi.entities.Rating;



@Repository
public interface RatingRepository extends JpaRepository <Rating, Long>  {

}
