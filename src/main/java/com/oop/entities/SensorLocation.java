package com.oop.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="sensors_locations")
public class SensorLocation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    private float lat;
    
    private float lon;
    
//    @JsonProperty("soldSensorId")
//    @Column(name = "sold_sensors_id")
//    private long soldSensorId;
    
    @OneToOne
    @JsonProperty
    @JoinColumn(name = "sold_sensors_id", referencedColumnName = "id", insertable = false, updatable = false)
    private SoldSensor soldSensor;
    
    public SensorLocation() {
    }

    public SensorLocation(float lat, float lon) {
        this.lat = lat;
        this.lon = lon;
//        this.soldSensorId = soldSensorId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public float getLat() {
        return lat;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }

    public float getLon() {
        return lon;
    }

    public void setLon(float lon) {
        this.lon = lon;
    }

    public SoldSensor getSoldSensor() {
        return soldSensor;
    }

    public void setSoldSensor(SoldSensor soldSensor) {
        this.soldSensor = soldSensor;
    }

}
