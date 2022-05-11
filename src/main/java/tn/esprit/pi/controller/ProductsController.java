package tn.esprit.pi.controller;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import tn.esprit.pi.entities.Products;
import tn.esprit.pi.entities.Rating;
import tn.esprit.pi.services.IProductCategoryService;
import tn.esprit.pi.services.IProductsService;
import tn.esprit.pi.services.IRatingService;
import tn.esprit.pi.services.ProductsService;

@CrossOrigin(origins = "*")
@RestController 
public class ProductsController {
	
	
	@Autowired 
	IProductsService productsService;
	@Autowired
	IProductCategoryService productCategoryService;
	
	
	
	@GetMapping("/afficherProducts")
	@ResponseBody 
	List<Products> afficherAllProducts(){
		return productsService.retrieveProducts();
	}
	
	@GetMapping("/afficherRecentProducts")
	@ResponseBody 
	List<Products> afficherRecentProducts(){
		
		return productsService.retrieveRecentProducts();
	}
	
	@GetMapping("/afficherProductByC/{idCategoryProd}")
	@ResponseBody 
	Set<Products> afficheProductByCategorie(@PathVariable("idCategoryProd")Long idCategoryProd){
		
		return productsService.retrieveProductByCategorie(idCategoryProd);
	}
	
	
	@GetMapping("/afficherProducts/{id}")
	@ResponseBody 
	Products afficherProducts(@PathVariable("idProd")Long idProd) {
		return productsService.retrieveProductById(idProd);
	}
	@GetMapping("/afficherProduct")
	@ResponseBody 
	Products afficherProducts2(@RequestParam("idProd")Long idProd) {
			return productsService.retrieveProductById(idProd);
	}
	
	
	@PostMapping("/ajouterproduct/{idCategoryProd}")
	@ResponseBody
	Products ajouterProducts(@RequestBody Products p, @PathVariable Long idCategoryProd) { 
		return productsService.saveProduct(p,idCategoryProd);
	}
	
	/**
	@PostMapping("/ajouterproduct")
	@ResponseBody
	Products ajouterProducts(@RequestBody Products p) { 
		
		return productsService.saveProduct(p);
	} **/
	
	
	@PutMapping("/updateproduct")
	@ResponseBody
	Products updateProducts(@RequestBody Products p) { 
		return productsService.updateProduct(p);
	}
	
	@DeleteMapping("/deleteproduct/{idProd}")
	@ResponseBody
	void supprimerProduct(@PathVariable("idProd") Long idProd) {
		productsService.deleteProducts(idProd);
	}
	
	@DeleteMapping("/deleteproduct2")
	@ResponseBody
	void supprimerProduct2(@RequestParam("idProd") Long idProd) {
		productsService.deleteProducts(idProd);
	}
	

	

}
