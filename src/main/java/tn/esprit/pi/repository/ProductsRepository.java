package tn.esprit.pi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import tn.esprit.pi.entities.Products;

@Repository
public interface ProductsRepository extends JpaRepository <Products, Long> {
	
	@Query("select p from Products p where p.name like %?1%")
	public Products findByName(String term);

}
