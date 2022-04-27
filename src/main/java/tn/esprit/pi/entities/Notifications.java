package tn.esprit.pi.entities;

import java.io.Serializable;

import javax.persistence.Entity;
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
@EqualsAndHashCode
@Builder
public class Notifications  implements Serializable {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	String notif;
	
	@ManyToOne
	public User user;
	
	@ManyToOne
	public Problems problem;


}
