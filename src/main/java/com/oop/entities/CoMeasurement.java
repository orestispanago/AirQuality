package com.oop.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "co_measurements")
public class CoMeasurement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
//
//    @Column(name = "sensors_locations_id")
//    private int sensorsLocationsId;
    @JsonProperty("co")
    @Column(name = "co")
    private float co;

    @CreationTimestamp
    @Column(name = "timestamp", updatable = false, nullable = false)
//    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp;

    public CoMeasurement() {
    }

    public CoMeasurement(float pm1, float pm25) {
        this.co = co;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

//    public int getSensorsLocationsId() {
//        return sensorsLocationsId;
//    }
//
//    public void setSensorsLocationsId(int sensorsLocationsId) {
//        this.sensorsLocationsId = sensorsLocationsId;
//    }
    public float getPm1() {
        return co;
    }

    public Date getTimestamp() {
        return timestamp;
    }

}
