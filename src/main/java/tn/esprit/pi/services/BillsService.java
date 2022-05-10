package tn.esprit.pi.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.pi.entities.Bills;
import tn.esprit.pi.repository.BillsRepository;

import tn.esprit.pi.repository.ProductsRepository;
import tn.esprit.pi.repository.UserRepository;
import tn.esprit.pi.entities.User;


@Service
public class BillsService implements IBillsService {

	@Autowired
    private BillsRepository billsRepository;
    @Autowired
    private UserRepository userRepository;


    @Override
    public Bills add(Bills bills) {
        return billsRepository.save(bills);
    }

    @Override
    public Bills update(Bills facture, Long id) {
        return billsRepository.save(facture);
    }

    @Override
    public void delete(long id) {
    	billsRepository.deleteById(id);
    }

    @Override
    public List<Bills> findAll() {
        return billsRepository.findAll();
    }


    @Override
    public Bills findById(Long id) {
        return billsRepository.findById(id).get();
    }

    @Override
    public List<Bills> getFacturesByClient(Long iduser) {
        return billsRepository.findAll()
                .stream()
                .filter(bills -> bills.getUser().getUserid().equals(iduser))
                .collect(Collectors.toList());
    }
}
