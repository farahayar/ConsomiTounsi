package tn.esprit.pi.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import tn.esprit.pi.entities.Products;



@Repository
public interface ProductsRepository extends JpaRepository <Products, Long> {
	@Query("select p from Products p where p.add_date = CURRENT_DATE")
	List<Products> getRecentProducts();
	
	
	
	
	

	/**
	 * @Query("SELECT r FROM RendezVous r where r.medecin.idMedecin=:idMedecin "
			 * + "and r.dateRdv BETWEEN :date1 and :date2") List<RendezVous>
			 * getRendezVousMedecin(@Param("idMedecin") Long idMedecin, @Param("date1")
			 * Date startDate, @Param("date2")Date endDate);
			 */
	/**
			 
			 @Query("Select s from Stock s where s.libelleStock =: lib and s.qte =: qtt ")
				List<Stock> retriveStockByLibelle(@Param ("lib")String libelle, @Param ("qtt")Integer qtTes );
			 **/

}
