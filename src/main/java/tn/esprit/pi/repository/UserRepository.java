package tn.esprit.pi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import tn.esprit.pi.entities.User;

@Repository
public interface UserRepository extends JpaRepository <User, Long> {

}