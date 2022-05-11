package tn.esprit.pi.batch;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import lombok.extern.slf4j.Slf4j;
import tn.esprit.pi.entities.Products;
import tn.esprit.pi.services.IProductsService;

@Slf4j
public class StockWriter implements ItemWriter<Products> {

    @Autowired
    private IProductsService productsService;

    /* écrire nos données dans la base de données*/
    public void write(List<? extends Products> products) {
            log.info("Enregistrement des lignes stocks dans la base de données", products);
            /*toDo 10*/
            productsService.saveListP(products);
            
    }
}
