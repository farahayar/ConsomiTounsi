package tn.esprit.pi.batch;

import org.springframework.batch.item.ItemProcessor;


import tn.esprit.pi.entities.Products;

public class StockProcessor implements ItemProcessor<Products, Products> {
	/*11. logique métier de notre job*/
	@Override
	public Products process(Products products) {
		
		products.setBarCode(products.getBarCode());
		products.setNameProd(products.getNameProd());
		products.setUnit_price_htva(products.getUnit_price_htva());
		products.setTva(products.getTva());
		products.setAdd_date(products.getAdd_date());
		//products.setProductCategory(products.getProductCategory());
		return products;
	}
}
