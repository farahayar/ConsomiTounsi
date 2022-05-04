package tn.esprit.pi.services;



import tn.esprit.pi.entities.Bills;


public interface IBillsService {
	
	/*public List<Client> findAll();

	public Page<Client> findAll(Pageable pageable);
	
	public Client findOne(Long id);
	
	public Client fetchByIdWithInvoices(Long id);
	
	public void save(Client client);
	
	public void delete(Long id);
	
	public List<Product> findByName(String term); */
	
	public void saveBills(Bills bills);
	
   // Products findProductById(Long id);
	
    public Bills findBillsById(Long id);
	
	public void deleteBills(Long id);
	
	public Bills fetchBillsByIdWithClientWithBillsItemWithProduct(Long id);
}
