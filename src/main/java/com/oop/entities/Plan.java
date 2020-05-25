/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oop.entities;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Administrator
 */

@Entity
@Table(name = "plans")
public class Plan implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    private String title;
    
    private String description;
    
    private String label;
    
    @Column(name = "price_per_month")
    private double pricePerMonth;
    
    private String feature1;
    
    private String feature2;
    
    private String feature3;
    
    public Plan() {};
    
    public Plan(String title, String description, String label, double pricePerMonth, String feature1, String feature2, String feature3) {
        this.title = title;
        this.description = description;
        this.label = label;
        this.pricePerMonth = pricePerMonth;
        this.feature1 = feature1;
        this.feature2 = feature2;
        this.feature3 = feature3;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public double getPricePerMonth() {
        return pricePerMonth;
    }

    public void setPricePerMonth(double pricePerMonth) {
        this.pricePerMonth = pricePerMonth;
    }

    public String getFeature1() {
        return feature1;
    }

    public void setFeature1(String feature1) {
        this.feature1 = feature1;
    }

    public String getFeature2() {
        return feature2;
    }

    public void setFeature2(String feature2) {
        this.feature2 = feature2;
    }

    public String getFeature3() {
        return feature3;
    }

    public void setFeature3(String feature3) {
        this.feature3 = feature3;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 41 * hash + Objects.hashCode(this.title);
        hash = 41 * hash + Objects.hashCode(this.description);
        hash = 41 * hash + Objects.hashCode(this.label);
        hash = 41 * hash + (int) (Double.doubleToLongBits(this.pricePerMonth) ^ (Double.doubleToLongBits(this.pricePerMonth) >>> 32));
        hash = 41 * hash + Objects.hashCode(this.feature1);
        hash = 41 * hash + Objects.hashCode(this.feature2);
        hash = 41 * hash + Objects.hashCode(this.feature3);
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
        final Plan other = (Plan) obj;
        if (this.id != other.id) {
            return false;
        }
        if (Double.doubleToLongBits(this.pricePerMonth) != Double.doubleToLongBits(other.pricePerMonth)) {
            return false;
        }
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.label, other.label)) {
            return false;
        }
        if (!Objects.equals(this.feature1, other.feature1)) {
            return false;
        }
        if (!Objects.equals(this.feature2, other.feature2)) {
            return false;
        }
        if (!Objects.equals(this.feature3, other.feature3)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Plan{" + "id=" + id + ", title=" + title + ", description=" + description + ", label=" + label + ", pricePerMonth=" + pricePerMonth + ", feature1=" + feature1 + ", feature2=" + feature2 + ", feature3=" + feature3 + '}';
    }
}
