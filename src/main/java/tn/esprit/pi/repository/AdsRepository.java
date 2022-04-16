package tn.esprit.pi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.pi.entities.Ads;


@Repository
public interface AdsRepository extends JpaRepository <Ads, Long> {

}
