package tn.esprit.pi.entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
class entityDelivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_delivery;
    private int id_cmd;
    private int id_deliveryp;
    private String statusd;
    private int cost;
    private String region;
    private int workload;
    private String transport;
    private Date dated; 
    
    public entityDelivery() {
    }

    public int getId() {
        return id_delivery;
    }

    public void setId(int id_delivery) {
        this.id_delivery = id_delivery;
    } 

    public int getId_cmd() {
        return this.id_cmd;
    }

    public void setId_cmd(int id_cmd) {
        this.id_cmd = id_cmd;
    }

    public int getId_deliveryp() {
        return this.id_deliveryp;
    }

    public void setId_deliveryp(int id_deliveryp) {
        this.id_deliveryp = id_deliveryp;
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

    public int getWorkload() {
        return this.workload;
    }

    public void setWorkload(int workload) {
        this.workload = workload;
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

}
