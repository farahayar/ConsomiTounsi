package tn.esprit.pi.services;



import java.util.List;

import tn.esprit.pi.entities.Bills;

public interface IBillsService {
	
	Bills add(Bills facture);
	Bills update(Bills facture, Long id);
    void delete(long id);
    List<Bills> findAll();
    Bills findById(Long id);
    List<Bills> getFacturesByClient(Long idClient);
}
