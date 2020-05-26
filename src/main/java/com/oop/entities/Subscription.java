/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oop.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.CreationTimestamp;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "subscriptions")
public class Subscription implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @CreationTimestamp
    @Column(name = "date_of_purchase", updatable = false)
    private Date dateOfPurchase;
    
    // TODO test if @JsonProperty is better
    @Column(name = "expiration_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date expirationDate;
    
    
    @ManyToOne()
    @JoinColumn(name = "plans_id", referencedColumnName = "id")
    private Plan plan;

    @ManyToOne()
    @JoinColumn(name = "users_id", referencedColumnName = "id")
    private AppUser user;
    
    public Subscription() {};
    
//    public Subscription(Date expirationDate) {
//        this.dateOfPurchase = null;
//        this.expirationDate = expirationDate;
//    }

    
    public Subscription(Date dateOfPurchase, Date expirationDate) {
        this.dateOfPurchase = dateOfPurchase;
        this.expirationDate = expirationDate;
    }

    public Date getDateOfPurchase() {
        return dateOfPurchase;
    }

    public void setDateOfPurchase(Date dateOfPurchase) {
        System.out.println("Called setter date of purchase?????????????????????????????????????");
        this.dateOfPurchase = dateOfPurchase;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Plan getPlan() {
        return plan;
    }

    public void setPlan(Plan plan) {
        this.plan = plan;
    }


    public AppUser getUser() {
        return user;
    }

    public void setUser(AppUser user) {
        this.user = user;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Subscription{" + "id=" + id + ", dateOfPurchase=" + dateOfPurchase + ", expirationDate=" + expirationDate + ", plan=" + plan + ", user=" + user + '}';
    }
    
}
