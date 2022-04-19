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

import org.apache.catalina.User;

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
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Problems  implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	Long idProb;
	
	String subject;
	boolean closed;
	
	@ManyToOne(fetch= FetchType.LAZY)
	public Userf user;
	
	@ManyToMany(fetch= FetchType.LAZY)
	public Set<Tags> tags;
	
	@OneToMany(fetch= FetchType.EAGER,mappedBy = "problem" ,cascade = CascadeType.ALL)
	public Set<Approved> Approveds;
	
	@OneToMany(fetch= FetchType.EAGER,mappedBy = "problem" ,cascade = CascadeType.ALL)
	public Set<Comments> comments;
	
	@OneToMany(fetch= FetchType.EAGER,mappedBy = "problem" ,cascade = CascadeType.ALL)
	public Set<Notifications> notifications;
	

}