package tn.esprit.pi.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


import tn.esprit.pi.entities.ItemBills;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import tn.esprit.pi.entities.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
@Entity
@Table(name = "bills")

public class Bills implements Serializable {
	
		private static final long serialVersionUID = 1L;

		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long idBill;

	    private float montantRemise;
	    private float montantFacture;

	    @Temporal(TemporalType.DATE)
	    private Date dateBill;
	    private Boolean active;

	    @ManyToOne(fetch = FetchType.EAGER)
	    @JoinColumn(name = "idUser")
	    @JsonIgnoreProperties({"roles","factures"})
	    private User user;

	    @OneToMany(cascade = CascadeType.ALL)
	    @JoinColumn(name = "idBill")
	    @JsonIgnoreProperties({"bill"})
	    private List<ItemBills> itemBills;
}