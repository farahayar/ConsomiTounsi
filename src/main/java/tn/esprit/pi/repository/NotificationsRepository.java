package tn.esprit.pi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.pi.entities.Notifications;

@Repository
public interface NotificationsRepository extends JpaRepository<Notifications, Long>{

}
