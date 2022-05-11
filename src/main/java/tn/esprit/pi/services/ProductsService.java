package tn.esprit.pi.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;



import lombok.extern.slf4j.Slf4j;
import tn.esprit.pi.entities.Ads;
import tn.esprit.pi.entities.ProductCategory;
import tn.esprit.pi.entities.Products;
import tn.esprit.pi.repository.ProductCategoryRepository;
import tn.esprit.pi.repository.ProductsRepository;

@Component
@Slf4j
@Service
public class ProductsService implements IProductsService {
	@Autowired
	ProductsRepository productsRepository;
	@Autowired
	ProductCategoryRepository productCategoryRepository;

	@Override
	public List<Products> retrieveProducts() {
		
		return  productsRepository.findAll();
	}
/**
public List<Products> retrieveRecentProducts(Long idProd) {
	Date d1= new Date();
	
	Products p = productsRepository.findById(idProd).orElse(null);
	if(p.getAdd_date().equals(d1))
		
		return  productsRepository.findAll();
	
	}
	**/

	@Override
	public Products retrieveProductById(Long idProd) {
		
		return productsRepository.findById(idProd).orElse(null);
	}
	

	@Override
	public Products saveProduct(Products p,Long idCategoryProd) {
		ProductCategory pc = productCategoryRepository.findById(idCategoryProd).orElse(null);
		p.setProductCategory(pc);
		// TODO Auto-generated method stub
		log.info("id cat est"+ idCategoryProd);
		return productsRepository.save(p);
		
	}

	/**
	
	@Override
	public Products saveProduct(Products p) {
		//ProductCategory pc =productCategoryRepository.findById(idCategoryProd).orElse(null);
		//p.setProductCategory(pc);
		// TODO Auto-generated method stub
		return productsRepository.save(p);
	}
	**/
	@Override
	public Products updateProduct(Products p) {		
		return productsRepository.save(p);
	}

	@Override
	public void deleteProducts(Long idProd) {
		Optional<Products> products = productsRepository.findById(idProd);
		if(products.isPresent()){
			productsRepository.deleteById(idProd);
		}else{
			System.out.println("No Product record exist for given id");
		}
		
	}
	@Override
	public List<Products> retrieveRecentProducts() {
		return productsRepository.getRecentProducts();
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public Set<Products> retrieveProductByCategorie(Long idCategoryProd) {
		ProductCategory pc = productCategoryRepository.findById(idCategoryProd).get();
		return pc.getProducts();
	}
	
	@Override
	public List<Products> saveListP (List<? extends Products> products) {
		// TODO Auto-generated method stub
		
		return (List<Products>) productsRepository.saveAll(products);
	}
	
	
	
	
	
	

}
