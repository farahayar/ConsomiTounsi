package tn.esprit.pi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.pi.entities.ProductCategory;
import tn.esprit.pi.entities.Products;
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
		ProductCategory productCategory = productCategoryRepository.findById(pc.getIdCategoryProd()).get();
		productCategory.setName_CategoryProd(pc.getName_CategoryProd());
		productCategory.setProducts(pc.getProducts());
		return productCategoryRepository.save(pc);
	}

	@Override
	public void deleteProductCategory(Long idCategoryProd) {
		Optional<ProductCategory> productcategory = productCategoryRepository.findById(idCategoryProd);
		if(productcategory.isPresent()){
			productCategoryRepository.deleteById(idCategoryProd);
		}else{
			System.out.println("No Product Category record exist for given id");
		}
				
	}

}
