package tn.esprit.pi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.pi.entities.Ads;
import tn.esprit.pi.entities.Products;
import tn.esprit.pi.repository.ProductsRepository;
@Service
public class ProductsService implements IProductsService {
	@Autowired
	ProductsRepository productsRepository;

	@Override
	public List<Products> retrieveProducts() {
		
		return  productsRepository.findAll();
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
		Products products = productsRepository.findById(p.getIdProd()).get();
		products.setBarCode(p.getBarCode());
		products.setNameProd(p.getNameProd());
		products.setUnit_price_htva(p.getUnit_price_htva());
		products.setType(p.getType());
		products.setProductCategory(p.getProductCategory());
		products.setAds(p.getAds());
		
		return productsRepository.save(products);
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

}
