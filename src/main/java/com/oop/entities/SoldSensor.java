package com.oop.entities;

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

    private boolean registered = false;

    @ManyToOne()
    @JoinColumn(name = "products_id", referencedColumnName = "id")
    private Product product;
   
    
    @ManyToOne()
    @JoinColumn(name = "users_id", referencedColumnName = "id")
    private AppUser user;
    
    public SoldSensor() {};
    

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public boolean isRegistered() {
        return registered;
    }

    public void setRegistered(boolean registered) {
        this.registered = registered;
    }



}
