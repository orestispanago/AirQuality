/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oop.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.Column;
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
public class SoldSensor {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    private short registered;
    
    //@OneToOne
    //@JoinColumn(name = "sensors_locations", referencedColumnName = "id")
    //private SensorLocation sensorLocation;
    @JsonProperty("productId")
    @Column(name = "products_id")
    private long productId;
    
    @ManyToOne()
    @JoinColumn(name = "products_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Product product;
    
    @JsonProperty("userId")
    @Column(name = "users_id")
    private long userId;
    
    @ManyToOne()
    @JoinColumn(name = "users_id", referencedColumnName = "id", insertable = false, updatable = false)
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 31 * hash + this.registered;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SoldSensor other = (SoldSensor) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.registered != other.registered) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SoldSensor{" + "id=" + id + ", registered=" + registered + '}';
    }
    
}
