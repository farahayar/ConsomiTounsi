package tn.esprit.pi.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
@EqualsAndHashCode
@Builder
public class Approved implements Serializable{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	boolean approved;
	
	@JsonIgnore	
	@ManyToOne(fetch= FetchType.LAZY)
	public tn.esprit.pi.entities.User user;
	
	@JsonIgnore	
	@ManyToOne(fetch= FetchType.LAZY)
	public Problems problem;

}
