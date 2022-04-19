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

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Builder
public class User implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int userid;
    public String mail;
    public String login;
    public String password;
    public String gender;
    public String fname;
    public String lname;
    public int phnum;
    public String address;
    public int zipcode;
    public String cin;
    public String role;
    public boolean banned;

  
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
