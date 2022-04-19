package tn.esprit.pi.entities;



import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
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
@EqualsAndHashCode
@Entity
public class Ads implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long idAds ;
	String nameAds  ;
	String channel  ;
	@Temporal(TemporalType.DATE)
	Date start_date;
	@Temporal(TemporalType.DATE)
	Date final_date;
	int nb_initial_views;
	int nb_final_views;
	float cost;
	String type_ads;
	
	@ManyToOne
	Products products;
	
	


}
