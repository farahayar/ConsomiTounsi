package tn.esprit.pi.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import tn.esprit.pi.entities.Bills;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
//@EqualsAndHashCode
@Entity
@Builder
@Table(name = "users")
public class User implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long userid;
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
    
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<Bills> bills;

	//public User() {
		//bills = new ArrayList<Bills>();
	//}

  
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
