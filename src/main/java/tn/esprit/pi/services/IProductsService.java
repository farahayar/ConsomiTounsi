package tn.esprit.pi.services;

import java.util.List;

import tn.esprit.pi.entities.Products;



public interface IProductsService {
	List<Products> retrieveProducts(); 
	Products retrieveProductById(Long idProd);
	Products saveProduct(Products p);
	Products updateProduct (Products p); 
	void deleteProducts (Long idProd);
	

}
