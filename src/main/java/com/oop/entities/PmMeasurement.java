package com.oop.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "pm_measurements")
public class PmMeasurement implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne()
    @JsonProperty
    @JoinColumn(name = "sensors_locations_id", referencedColumnName = "id",updatable = false)
    private SensorLocation sensorLocation;
//
//    @Column(name="sensors_locations_id")
//    private long sensorLocationId;
    
    @JsonProperty("pm1")
    @Column(name = "pm1")
    private float pm1;

    @JsonProperty("pm25")
    @Column(name = "pm25")
    private float pm25;

    @CreationTimestamp // comment out and set updateble=true to insert older values
    @Column(name = "timestamp", updatable = false, nullable = false)
    private Date timestamp;

    public PmMeasurement() {
    }

    public PmMeasurement(float pm1, float pm25) {
        this.pm1 = pm1;
        this.pm25 = pm25;
    }

    public long getId() {
        return id;
    }

    public float getPm1() {
        return pm1;
    }

    public float getPm25() {
        return pm25;
    }

    public Date getTimestamp() {
        return timestamp;
    }
    
    public void setSensorLocation(SensorLocation sensorLocation) {
        this.sensorLocation = sensorLocation;
    }

    @Override
    public String toString() {
        return "PmMeasurement{" + "id=" + id + ", sensorLocation=" + sensorLocation + ", pm1=" + pm1 + ", pm25=" + pm25 + ", timestamp=" + timestamp + '}';
    }

}
