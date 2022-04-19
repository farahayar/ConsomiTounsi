package tn.esprit.pi.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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
public class Userf  implements Serializable{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mail;
    private String login;
    private String password;
    private String gender;
    private String fname;
    private String lname;
    private int phnum;
    private String address; 
    private int zipcode;
    private String cin;
    private String role;
    private boolean banned;
    
	@OneToMany(fetch= FetchType.EAGER,mappedBy = "user" ,cascade = CascadeType.ALL)
	public Set<Problems> problems;
	
	@OneToMany(fetch= FetchType.EAGER,mappedBy = "user" ,cascade = CascadeType.ALL)
	public Set<Chats> chats;
	
	@OneToMany(fetch= FetchType.EAGER,mappedBy = "user" ,cascade = CascadeType.ALL)
	public Set<Approved> Approveds;
	
	@OneToMany(fetch= FetchType.EAGER,mappedBy = "user" ,cascade = CascadeType.ALL)
	public Set<Comments> comments;
	
	@OneToMany(fetch= FetchType.EAGER,mappedBy = "user" ,cascade = CascadeType.ALL)
	public Set<Notifications> notifications;

}
