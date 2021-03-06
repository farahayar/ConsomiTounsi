package tn.esprit.pi.entities;

import java.util.Date;
import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

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
//@EqualsAndHashCode
@Entity
@Builder
public class User implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long userid;
    public String mail;
    public String username;
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

  
    @ManyToMany( cascade = CascadeType.ALL)
    private Set<Products> products;
    
    @OneToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL, mappedBy="productsrating")
	private Set<Rating> userrating;
    @JsonIgnore
    @OneToMany(fetch= FetchType.EAGER,mappedBy = "user" ,cascade = CascadeType.ALL)
	public Set<Problems> problems;
	
    @JsonIgnore
	@OneToMany(fetch= FetchType.EAGER,mappedBy = "sender" ,cascade = CascadeType.ALL)
	public Set<Chats> chatsSender;
    
    @JsonIgnore
	@OneToMany(fetch= FetchType.EAGER,mappedBy = "reciver" ,cascade = CascadeType.ALL)
	public Set<Chats> chatsreciver;
	
    @JsonIgnore
	@OneToMany(fetch= FetchType.EAGER,mappedBy = "user" ,cascade = CascadeType.ALL)
	public Set<Approved> Approveds;
	
    @JsonIgnore
	@OneToMany(fetch= FetchType.EAGER,mappedBy = "user" ,cascade = CascadeType.ALL)
	public Set<Comments> comments;
	
    @JsonIgnore
	@OneToMany(fetch= FetchType.EAGER,mappedBy = "user" ,cascade = CascadeType.ALL)
	public Set<Notifications> notifications;

}
