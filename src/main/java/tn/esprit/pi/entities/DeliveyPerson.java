package tn.esprit.pi.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
class entityDeliveryPerson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_deliveryp;
    private int id_delivery;
    private String statusp;
    private String name_deliveryp;
    private String regionp;
    private int bonus;
    
    
    public entityDeliveryPerson() {
    }

    public int getId_deliveryp() {
        return id_deliveryp;
    }

    public void setId_deliveryp(int id_deliveryp) {
        this.id_deliveryp = id_deliveryp;
    } 

    public int getId_delivery() {
        return this.id_delivery;
    }

    public void setId_delivery(int id_delivery) {
        this.id_delivery = id_delivery;
    }

    public String getStatusp() {
        return this.statusp;
    }

    public void setStatusp(String statusp) {
        this.statusp = statusp;
    }

    public String getName_deliveryp() {
        return this.name_deliveryp;
    }

    public void setName_deliveryp(String name_deliveryp) {
        this.name_deliveryp = name_deliveryp;
    }

    public String getRegionp() {
        return this.regionp;
    }

    public void setRegionp(String regionp) {
        this.regionp = regionp;
    }

    public int getBonus() {
        return this.bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

}
