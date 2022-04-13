package tn.esprit.pi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import tn.esprit.pi.entities.TargetMarket;

@Repository
public interface TargetMarketRepository extends JpaRepository <TargetMarket, Long> {

}
