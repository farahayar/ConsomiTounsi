package tn.esprit.pi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.pi.repository.BillsRepository;
import tn.esprit.pi.repository.ProductsRepository;
import tn.esprit.pi.repository.UserRepository;
import tn.esprit.pi.entities.User;
import tn.esprit.pi.entities.Bills;
import tn.esprit.pi.entities.Products;

@Service
public class BillsService implements IBillsService {

	/*@Autowired
	private UserRepository userRepository;

	@Autowired
	private ProductsRepository productsRepository;*/

	@Autowired
	private BillsRepository billsRepository; 

	/*----- Method List -----
	@Override
	@Transactional(readOnly = true)
	public List<Client> findAll() {
		return (List<Client>) clientDao.findAll();
	}*/

	/*----- Paginator -----
	@Override
	@Transactional(readOnly = true)
	public Page<Client> findAll(Pageable pageable) {
		return clientDao.findAll(pageable);
	}*/

	/*----- Method Find By ID -----
	@Override
	@Transactional(readOnly = true)
	public Client findOne(Long id) {
		return clientDao.findById(id).orElse(null);
	}*/
	
	/*@Override
	@Transactional(readOnly = true)
	public Client fetchByIdWithInvoices(Long id) {
		return clientDao.fetchByIdWithInvoices(id);
	}

	/*----- Method Save -----
	@Override
	@Transactional
	public void save(Client client) {
		clientDao.save(client);
	}*/

	/*----- Method Delete -----
	@Override
	@Transactional
	public void delete(Long id) {
		clientDao.deleteById(id);
	}*/

	/*----- Method Find by Name (Product) -----
	@Override
	@Transactional(readOnly = true)
	public List<Product> findByName(String term) {
		return productDao.findByName(term);
	}*/

	/*----- Method Save (Invoice) -----*/
	@Override
	@Transactional
	public void saveBills(Bills bills) {
		billsRepository.save(bills);
	}
	
	/*----- Method Find Product by ID -----*/
	/*@Override
	@Transactional(readOnly = true)
	public Products findProductById(Long id) {
		return productsRepository.findById(id).orElse(null);
	}*/
	
	

	/*----- Method Find by ID (Invoice) -----*/
	@Override
	@Transactional(readOnly = true)
	public Bills findBillsById(Long id) {
		return billsRepository.findById(id).orElse(null);
	}

	/*----- Method Delete (Invoice) -----*/
	@Override
	@Transactional
	public void deleteBills(Long id) {
		billsRepository.deleteById(id);	
	}

	/*----- Method Fetch Invoice with Client with Invoice -----*/
	@Override
	@Transactional(readOnly = true)
	public Bills fetchBillsByIdWithClientWithBillsItemWithProduct(Long id) {
		return billsRepository.fetchByIdWithUserWithBillsItemWithProduct(id);
	}
	/*----- Method Find by Name (Product) -----*/
	@Override
	@Transactional(readOnly = true)
	public List<Products> findByName(String term) {
		return productsRepository.findByName(term);
	}

}
