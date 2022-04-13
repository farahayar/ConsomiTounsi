package tn.esprit.pi.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public
class User {

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

    public User() {
    }

    public int getId() {
        return userid;
    }

    public void setId(int id) {
        this.userid = id;
    }

    public String getMail() {
        return this.mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getLogin() {
        return this.login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getFname() {
        return this.fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return this.lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public int getPhnum() {
        return this.phnum;
    }

    public void setPhnum(int phnum) {
        this.phnum = phnum;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getZipcode() {
        return this.zipcode;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }

    public String getCin() {
        return this.cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getRole() {
        return this.role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isBanned() {
        return this.banned;
    }

    public boolean getBanned() {
        return this.banned;
    }

    public void setBanned(boolean banned) {
        this.banned = banned;
    }
}
