package tn.esprit.pi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import tn.esprit.pi.entities.Products;

@Repository
public interface ProductsRepository extends JpaRepository <Products, Long> {

}
