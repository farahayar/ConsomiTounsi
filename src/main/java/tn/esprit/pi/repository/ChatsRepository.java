package tn.esprit.pi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.pi.entities.Chats;

@Repository
public interface ChatsRepository extends JpaRepository<Chats, Long>{

}
