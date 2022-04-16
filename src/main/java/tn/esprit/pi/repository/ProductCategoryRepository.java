package tn.esprit.pi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import tn.esprit.pi.entities.ProductCategory;

@Repository
public interface ProductCategoryRepository extends JpaRepository <ProductCategory, Long> {

}
