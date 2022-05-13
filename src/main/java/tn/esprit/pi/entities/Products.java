package tn.esprit.pi.entities;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
@Builder
@Entity
public class Products implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long idProd ;
	String barCode  ;
	String nameProd  ;
	float unit_price_htva;
	float tva;
	@Temporal(TemporalType.DATE)
	Date add_date;
	@JsonIgnore
	@ManyToOne
	ProductCategory productCategory;
	
	@OneToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL, mappedBy="products")
	private Set<Ads> ads;
	
	@ManyToMany(mappedBy="products",cascade = CascadeType.ALL)
	private Set<User> user;
	
	@OneToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL, mappedBy="productsrating")
	private Set<Rating> rating;
	@OneToMany(fetch= FetchType.EAGER,mappedBy = "product" ,cascade = CascadeType.ALL)
	public Set<Comments> comments;
	
	
	
	
	

}
