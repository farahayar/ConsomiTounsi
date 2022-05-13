package tn.esprit.pi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.pi.entities.User;

@Repository
public interface UserDAO extends CrudRepository<User, Integer> {
	User findByUsername(String username);
}