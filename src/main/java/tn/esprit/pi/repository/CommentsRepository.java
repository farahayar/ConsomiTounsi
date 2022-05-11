package tn.esprit.pi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.pi.entities.Comments;

@Repository
public interface CommentsRepository extends JpaRepository<Comments, Long>{

	Comments findByApprovedGreaterThan(int nb);
}
