package tn.esprit.pi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.pi.entities.Products;
import tn.esprit.pi.repository.ProductsRepository;
@Service
public class ProductsService implements IProductsService {
	@Autowired
	ProductsRepository productsRepository;

	@Override
	public List<Products> retrieveProducts() {
		
		return (List<Products>) productsRepository.findAll();
	}

	@Override
	public Products retrieveProductById(Long idProd) {
		
		return productsRepository.findById(idProd).orElse(null);
	}

	@Override
	public Products saveProduct(Products p) {
		// TODO Auto-generated method stub
		return productsRepository.save(p);
	}

	@Override
	public Products updateProduct(Products p) {
		// TODO Auto-generated method stub
		return productsRepository.save(p);
	}

	@Override
	public void deleteProducts(Long idProd) {
		productsRepository.deleteById(idProd);
		
	}

}
