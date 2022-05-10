package tn.esprit.pi.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import tn.esprit.pi.entities.ItemBills;
import tn.esprit.pi.repository.ItemBillsRepository;


public class ItemBillsService implements IItemBillsService {
	 @Autowired
	    private ItemBillsRepository itemBillsRepository;

	    @Override
	    public ItemBills add(ItemBills itemBills) {
	        return itemBillsRepository.save(itemBills);
	    }

	    @Override
	    public ItemBills update(ItemBills detailFacture, Long id) {
	        return null;
	    }

	    @Override
	    public void delete(long id) {
	    	itemBillsRepository.deleteById(id);
	    }

	    @Override
	    public List<ItemBills> findAll() {
	        return itemBillsRepository.findAll();
	    }


	    @Override
	    public ItemBills findById(Long id) {
	        return itemBillsRepository.getById(id);
	    }
	}

