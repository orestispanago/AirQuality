package com.oop.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "sold_sensors_users")
public class SoldSensor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private short registered;

    @ManyToOne()
    @JoinColumn(name = "products_id", referencedColumnName = "id")
    private Product product;
   
    
    @ManyToOne()
    @JoinColumn(name = "users_id", referencedColumnName = "id")
    private AppUser user;
    
    public SoldSensor() {};
    
    public SoldSensor(short registered) {
        this.registered = registered;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public short getRegistered() {
        return registered;
    }

    public void setRegistered(short registered) {
        this.registered = registered;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public AppUser getUser() {
        return user;
    }

    public void setUser(AppUser user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "SoldSensor{" + "id=" + id + ", registered=" + registered + ", product=" + product + ", user=" + user + '}';
    }



}
