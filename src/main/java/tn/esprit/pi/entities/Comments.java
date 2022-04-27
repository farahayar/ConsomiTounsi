package tn.esprit.pi.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
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
@Builder
public class Comments implements Serializable {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	boolean response;
	String comment;
	
	@ManyToOne(fetch= FetchType.LAZY)
	public User user;
	
	@ManyToOne(fetch= FetchType.LAZY)
	public Problems problem;
	
	@ManyToOne(fetch= FetchType.LAZY)
	public Products product;

}
