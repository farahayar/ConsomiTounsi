package tn.esprit.pi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.pi.entities.Tags;


@Repository
public interface TagsRepository extends JpaRepository<Tags, Long>{

	Tags findByTagLike(String tag);
}
