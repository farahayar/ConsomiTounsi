package tn.esprit.pi.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import tn.esprit.pi.entities.Bills;

public interface BillsRepository extends JpaRepository<Bills, Long> {
	
	// b = bills
	// u = user
	// l(L) = items
	@Query("select b from Bills b join fetch b.user u join fetch b.items l join fetch l.product where b.id = ?1")
	public Bills fetchByIdWithUserWithBillsItemWithProduct(Long id);

}
