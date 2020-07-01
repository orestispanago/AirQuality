package com.oop.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "subscriptions")
public class Subscription implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @CreationTimestamp
    @Column(name = "date_of_purchase")
    private Date dateOfPurchase;

    @Column(name = "expiration_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date expirationDate;

    @ManyToOne
    private Plan plan;

    @OneToOne
    private AppUser user;

    public Subscription() {
    }

    public Subscription(Plan plan, AppUser user) {
        this.dateOfPurchase = new Date();
        this.expirationDate = new Date(dateOfPurchase.getTime() + 2629746000L);
        this.plan = plan;
        this.user = user;
    }

    public Date getDateOfPurchase() {
        return dateOfPurchase;
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
