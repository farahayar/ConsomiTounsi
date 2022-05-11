package tn.esprit.pi.services;

import java.util.Date;
import java.util.List;
import java.util.Set;



import tn.esprit.pi.entities.Products;



public interface IProductsService {
	List<Products> retrieveProducts(); 
	List<Products> retrieveRecentProducts(); 
	Products retrieveProductById(Long idProd);
	Products saveProduct(Products p, Long idCategoryProd);
	//Products saveProduct(Products p);
	Products updateProduct (Products p); 
	void deleteProducts (Long idProd);
	Set<Products> retrieveProductByCategorie(Long idCategoryProd);
	List<Products> saveListP (List<? extends Products> products);

	

}
