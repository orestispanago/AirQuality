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
@Table(name = "co_measurements")
public class CoMeasurement {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private double co;
    
    @Temporal(TemporalType.DATE)
    private Date timestamp;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "sensor_id", referencedColumnName = "id")
    private SensorLocation sensorLocation;
    
    public CoMeasurement() {};

    public CoMeasurement(double co, Date timestamp, SensorLocation sensorLocation) {
        this.co = co;
        this.timestamp = timestamp;
        this.sensorLocation = sensorLocation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getCo() {
        return co;
    }

    public void setCo(double co) {
        this.co = co;
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
        int hash = 7;
        hash = 83 * hash + this.id;
        hash = 83 * hash + (int) (Double.doubleToLongBits(this.co) ^ (Double.doubleToLongBits(this.co) >>> 32));
        hash = 83 * hash + Objects.hashCode(this.timestamp);
        hash = 83 * hash + Objects.hashCode(this.sensorLocation);
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
        final CoMeasurement other = (CoMeasurement) obj;
        if (this.id != other.id) {
            return false;
        }
        if (Double.doubleToLongBits(this.co) != Double.doubleToLongBits(other.co)) {
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
        return "CoMeasurement{" + "id=" + id + ", co=" + co + ", timestamp=" + timestamp + ", sensorLocation=" + sensorLocation + '}';
    }
    
}
