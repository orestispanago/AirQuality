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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @CreationTimestamp
    @Column(name = "date_of_purchase",updatable = false, nullable = false)
    private Date dateOfPurchase;
    
    // TODO test if @JsonProperty is better
    @Column(name = "expiration_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date expirationDate;
    
    
    @ManyToOne()
    @JoinColumn(name = "plans_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Plan plan;
    
    @JsonProperty("userId")
    @Column(name = "users_id")
    private long userId;
    
    @ManyToOne()
    @JoinColumn(name = "users_id", referencedColumnName = "id", insertable = false, updatable = false)
    private AppUser user;
    
    public Subscription() {};
    
    public Subscription(Date expirationDate) {
        this.dateOfPurchase = null;
        this.expirationDate = expirationDate;
    }

    
    public Subscription(Date dateOfPurchase, Date expirationDate) {
        this.dateOfPurchase = dateOfPurchase;
        this.expirationDate = expirationDate;
    }

    public Date getDateOfPurchase() {
        return dateOfPurchase;
    }

    public void setDateOfPurchase(Date dateOfPurchase) {
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

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
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
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 41 * hash + Objects.hashCode(this.dateOfPurchase);
        hash = 41 * hash + Objects.hashCode(this.expirationDate);
        hash = 41 * hash + Objects.hashCode(this.plan);
        hash = 41 * hash + (int) (this.userId ^ (this.userId >>> 32));
        hash = 41 * hash + Objects.hashCode(this.user);
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
        final Subscription other = (Subscription) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.userId != other.userId) {
            return false;
        }
        if (!Objects.equals(this.dateOfPurchase, other.dateOfPurchase)) {
            return false;
        }
        if (!Objects.equals(this.expirationDate, other.expirationDate)) {
            return false;
        }
        if (!Objects.equals(this.plan, other.plan)) {
            return false;
        }
        if (!Objects.equals(this.user, other.user)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Subscription{" + "id=" + id + ", dateOfPurchase=" + dateOfPurchase + ", expirationDate=" + expirationDate + ", plan=" + plan + ", userId=" + userId + ", user=" + user + '}';
    }
    


    
}
