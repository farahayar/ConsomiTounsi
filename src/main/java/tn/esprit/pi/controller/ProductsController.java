package tn.esprit.pi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import tn.esprit.pi.entities.Products;
import tn.esprit.pi.services.IProductsService;
import tn.esprit.pi.services.ProductsService;


@RestController 
public class ProductsController {
	@Autowired 
	IProductsService productsService;
	
	@GetMapping("/afficherProducts")
	@ResponseBody //pour afficher resultat
	List<Products> afficherAllProducts(){
		return productsService.retrieveProducts();
	}
	
	
	@GetMapping("/afficherProducts/{id}")
	@ResponseBody //pour afficher resultat
	Products afficherProducts(@PathVariable("idProd")Long idProd) {
		return productsService.retrieveProductById(idProd);
	}
	@GetMapping("/afficherProduct")
	@ResponseBody //pour afficher resultat
	Products afficherProducts2(@RequestParam("idProd")Long idProd) {
			return productsService.retrieveProductById(idProd);
	}
	
	
	@PostMapping("/ajouterproduct")
	@ResponseBody
	Products ajouterProducts(@RequestBody Products p) { //yaani bch naadih fl body les info
		
		return productsService.saveProduct(p);
	}
	
	@PostMapping("/ajouterproduct2")
	@ResponseBody
	Products ajouterProducts2(@RequestParam Products p) { //yaani bch naadih fl body les info
		return productsService.saveProduct(p);
	}
	
	
	@PutMapping("/updateproduct")
	@ResponseBody
	Products updateProducts(@RequestBody Products p) { //yaani bch naadih fl body les info nzid nes2el farah
		return productsService.updateProduct(p);
	}
	
	@DeleteMapping("/deleteproduct/{id}")
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
