package tn.esprit.pi.services;

import java.util.List;

import tn.esprit.pi.entities.ItemBills;

public interface IItemBillsService {
	ItemBills add(ItemBills detailFacture);
	ItemBills update(ItemBills detailFacture, Long id);
	    void delete(long id);
	    List<ItemBills> findAll();
	    ItemBills findById(Long id);
}
