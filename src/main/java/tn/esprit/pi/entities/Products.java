package tn.esprit.pi.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity

public class Products implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long idProd ;
	String barCode  ;
	String nameProd  ;
	float unit_price_htva=0.00f;
	String type;
	final float tva = 0.2f;
	@ManyToOne
	ProductCategory productCategory;
	@OneToMany(fetch=FetchType.EAGER, cascade = CascadeType.ALL, mappedBy="products")
	private Set<Ads> ads;
	
	@OneToMany(fetch= FetchType.EAGER,mappedBy = "product" ,cascade = CascadeType.ALL)
	public Set<Comments> comments;

	@ManyToMany
	private Set<Delivery> Delivery;
	
	
	
	
	

}
