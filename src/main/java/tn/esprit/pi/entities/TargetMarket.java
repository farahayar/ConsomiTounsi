package tn.esprit.pi.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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

public class TargetMarket {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int idTarget;
	int age;
	String gender;
	String country;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="targetMarket")
	private Set<Ads> Ads;

}
