/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oop.entities;

import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "pm_measurements")
public class PmMeasurement {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private double pm1;
    
    private double pm25;
    
    @Temporal(TemporalType.DATE)
    private Date timestamp;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "sensors_locations_id", referencedColumnName = "id")
    private SensorLocation sensorLocation;
    
    public PmMeasurement() {};

    public PmMeasurement(double pm1, double pm25, Date timestamp, SensorLocation sensorLocation) {
        this.pm1 = pm1;
        this.pm25 = pm25;
        this.timestamp = timestamp;
        this.sensorLocation = sensorLocation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPm1() {
        return pm1;
    }

    public void setPm1(double pm1) {
        this.pm1 = pm1;
    }

    public double getPm25() {
        return pm25;
    }

    public void setPm25(double pm25) {
        this.pm25 = pm25;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public SensorLocation getSensorLocation() {
        return sensorLocation;
    }

    public void setSensorLocation(SensorLocation sensorLocation) {
        this.sensorLocation = sensorLocation;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + this.id;
        hash = 71 * hash + (int) (Double.doubleToLongBits(this.pm1) ^ (Double.doubleToLongBits(this.pm1) >>> 32));
        hash = 71 * hash + (int) (Double.doubleToLongBits(this.pm25) ^ (Double.doubleToLongBits(this.pm25) >>> 32));
        hash = 71 * hash + Objects.hashCode(this.timestamp);
        hash = 71 * hash + Objects.hashCode(this.sensorLocation);
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
        final PmMeasurement other = (PmMeasurement) obj;
        if (this.id != other.id) {
            return false;
        }
        if (Double.doubleToLongBits(this.pm1) != Double.doubleToLongBits(other.pm1)) {
            return false;
        }
        if (Double.doubleToLongBits(this.pm25) != Double.doubleToLongBits(other.pm25)) {
            return false;
        }
        if (!Objects.equals(this.timestamp, other.timestamp)) {
            return false;
        }
        if (!Objects.equals(this.sensorLocation, other.sensorLocation)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PmMeasurement{" + "id=" + id + ", pm1=" + pm1 + ", pm25=" + pm25 + ", timestamp=" + timestamp + ", sensorLocation=" + sensorLocation + '}';
    }
    
}
