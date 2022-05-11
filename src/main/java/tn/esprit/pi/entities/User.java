package tn.esprit.pi.entities;

import java.util.Date;
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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class User {

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

  
    @ManyToMany( cascade = CascadeType.ALL)
    private Set<Products> products;
    
    @OneToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL, mappedBy="productsrating")
	private Set<Rating> userrating;
}
