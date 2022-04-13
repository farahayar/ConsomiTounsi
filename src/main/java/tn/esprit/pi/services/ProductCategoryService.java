package tn.esprit.pi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.pi.entities.ProductCategory;
import tn.esprit.pi.entities.TargetMarket;
import tn.esprit.pi.repository.ProductCategoryRepository;
@Service
public class ProductCategoryService implements IProductCategoryService {
	@Autowired
	ProductCategoryRepository productCategoryRepository;

	@Override
	public List<ProductCategory> retrieveProductCategory() {
		
		return (List<ProductCategory>) productCategoryRepository.findAll();
	}

	@Override
	public ProductCategory retrieveProductCategoryById(Long idCategoryProd) {
		return productCategoryRepository.findById(idCategoryProd).orElse(null);
	}

	@Override
	public ProductCategory saveProductCategory(ProductCategory pc) {
		
		return productCategoryRepository.save(pc);
	}

	@Override
	public ProductCategory updateProductCategory(ProductCategory pc) {
		return productCategoryRepository.save(pc);
	}

	@Override
	public void deleteProductCategory(Long idCategoryProd) {
		productCategoryRepository.deleteById(idCategoryProd);
		
	}

}
