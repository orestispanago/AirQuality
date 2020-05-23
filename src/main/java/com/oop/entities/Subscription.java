/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oop.entities;

import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
public class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @CreationTimestamp
    @Column(name = "date_of_purchase",updatable = false, nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateOfPurchase;

    @Column(name = "expiration_date")
    @Temporal(TemporalType.DATE)
    private Date expirationDate;

    public Subscription(Date dateOfPurchase, Date expirationDate) {
        this.dateOfPurchase = dateOfPurchase;
        this.expirationDate = expirationDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 41 * hash + Objects.hashCode(this.dateOfPurchase);
        hash = 41 * hash + Objects.hashCode(this.expirationDate);
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
        if (!Objects.equals(this.dateOfPurchase, other.dateOfPurchase)) {
            return false;
        }
        if (!Objects.equals(this.expirationDate, other.expirationDate)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Subscription{" + "id=" + id + ", dateOfPurchase=" + dateOfPurchase + ", expirationDate=" + expirationDate + '}';
    }

}
