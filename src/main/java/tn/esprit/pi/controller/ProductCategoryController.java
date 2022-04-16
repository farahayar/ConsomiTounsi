package tn.esprit.pi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.pi.entities.ProductCategory;
import tn.esprit.pi.entities.Products;
import tn.esprit.pi.services.IProductCategoryService;
import tn.esprit.pi.services.IProductsService;

@RestController 
public class ProductCategoryController {
	@Autowired 
	IProductCategoryService productCategoryService;
	
	@GetMapping("/afficherAllPc")
	@ResponseBody 
	List<ProductCategory> afficherAllPc(){
		return productCategoryService.retrieveProductCategory();
	}
	
	
	@GetMapping("/afficherPc/{id}")
	@ResponseBody 
	ProductCategory afficherPc(@PathVariable("idCategoryProd")Long idCategoryProd) {
		return productCategoryService.retrieveProductCategoryById(idCategoryProd);
	}
	@GetMapping("/afficherPc")
	@ResponseBody 
	ProductCategory afficherPc2(@RequestParam("idCategoryProd")Long idCategoryProd) {
			return productCategoryService.retrieveProductCategoryById(idCategoryProd);
	}
	
	
	@PostMapping("/ajouterPc")
	@ResponseBody
	ProductCategory ajouterPc(@RequestBody ProductCategory pc) { 
		
		return productCategoryService.saveProductCategory(pc);
	}
	
	@PostMapping("/ajouterPc2")
	@ResponseBody
	ProductCategory ajouterPc2(@RequestParam ProductCategory pc) { 
		return productCategoryService.saveProductCategory(pc);
	}
	
	
	@PutMapping("/updatePc")
	@ResponseBody
	ProductCategory updatePc(@RequestBody ProductCategory pc) { 
		return productCategoryService.updateProductCategory(pc);
	}
	
	@DeleteMapping("/deletePc/{id}")
	@ResponseBody
	void supprimerPc(@PathVariable("idCategoryProd") Long idCategoryProd) {
		productCategoryService.deleteProductCategory(idCategoryProd);
	}
	
	@DeleteMapping("/deletePc2")
	@ResponseBody
	void supprimerPc2(@RequestParam("idCategoryProd") Long idCategoryProd) {
		productCategoryService.deleteProductCategory(idCategoryProd);
	}
	

}
