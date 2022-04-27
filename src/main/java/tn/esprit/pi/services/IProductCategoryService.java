package tn.esprit.pi.services;

import java.util.List;

import tn.esprit.pi.entities.ProductCategory;



public interface IProductCategoryService {
	List<ProductCategory> retrieveProductCategory(); 
	ProductCategory retrieveProductCategoryById(Long idCategoryProd);
	ProductCategory saveProductCategory(ProductCategory pc);
	ProductCategory updateProductCategory (ProductCategory pc); 
	void deleteProductCategory (Long idCategoryProd);

}
