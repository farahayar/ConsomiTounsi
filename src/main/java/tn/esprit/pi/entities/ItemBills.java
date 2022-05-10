package tn.esprit.pi.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import tn.esprit.pi.entities.Bills;
import tn.esprit.pi.entities.Products;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
@Entity
@Table(name = "items_bills")
public class ItemBills implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idItemBills;

    private int qte;
    private float prixtotal;
    private int pourcentageRemise;
    private float montantRemise;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idBill")
    @JsonIgnoreProperties({"user","detailBills"})
    private Bills bill;

//    @ManyToOne(fetch = FetchType.EAGER ,cascade = CascadeType.REMOVE)
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idProd")
    @JsonIgnoreProperties({"detailFactures"})
    private Products product;
}