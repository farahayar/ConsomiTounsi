package tn.esprit.pi.entities;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;

public class StockFieldSetMapper implements FieldSetMapper<Products> {
    @Override
    public Products mapFieldSet(FieldSet fieldSet) {
        return Products.builder()
        		.barCode(fieldSet.readString(0))
        		.nameProd(fieldSet.readString(0))
        		.unit_price_htva(20)
        		.tva(20)
        		.build();
        		
        		
        		
               
    }
    
  
}

