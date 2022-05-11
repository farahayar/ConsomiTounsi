package tn.esprit.pi.entities;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Rating {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long idRating;
	Integer star_number;
	
	@JsonIgnore
	@ManyToOne
	Products productsrating;
	
	@JsonIgnore
	@ManyToOne
	User userrating;
	

	

	
	
	

}
