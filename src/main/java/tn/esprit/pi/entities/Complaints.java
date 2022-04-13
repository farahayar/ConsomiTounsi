package tn.esprit.pi.entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
class entityComplaints {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_complaint;
    private int id_user;
    private String statusc;
    private String description;
    private String type;
    private Date datec;
    
    
    public entityComplaints() {
    }

    public int getId_complaint() {
        return id_complaint;
    }

    public void setId_complaint(int id_complaint) {
        this.id_complaint = id_complaint;
    } 

    public int getId_user() {
        return this.id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getStatusc() {
        return this.statusc;
    }

    public void setStatusc(String statusc) {
        this.statusc = statusc;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDatec() {
        return this.datec;
    }

    public void setDatec(Date datec) {
        this.datec = datec;
    }

}

