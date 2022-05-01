package tn.esprit.pi.entities;


import java.sql.Date;
import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Table(name = "Deliveries")
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_delivery;
    @Column(name="Delivery Person ID")
    private String statusd;
    @Column(name="Cost")
    private int cost;
    @Column(name="Region")
    private String region;
    @Column(name="Vehicle")
    @Enumerated(EnumType.STRING)
    private String transport;
    @Column(name="Date")
    private Date dated; 
    
    public Delivery() {
    }

    public Long getId() {
        return id_delivery;
    }
    
    
    public void setId(Long id_delivery) {
        this.id_delivery = id_delivery;
    } 

    public String getStatusd() {
        return this.statusd;
    }

    public void setStatusd(String statusd) {
        this.statusd = statusd;
    }

    public int getCost() {
        return this.cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getRegion() {
        return this.region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
    
    public String getTransport() {
        return this.transport;
    }

    public void setTransport(String transport) {
        this.transport = transport;
    }

    public Date getDated() {
        return this.dated;
    }

    public void setDated(Date dated) {
        this.dated = dated;
    }

    @Override
	public String toString() {
		return "Delivery [id=" + id_delivery + ", Status" + statusd + ", Cost=" + cost + "Address=" + region + "Vehicle=" + transport + "Date=" + dated;
	}

}
