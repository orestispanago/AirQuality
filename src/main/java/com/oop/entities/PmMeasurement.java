package com.oop.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
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
public class PmMeasurement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
//    @JsonProperty
    @ManyToOne()
    @JoinColumn(name = "sensors_locations_id", referencedColumnName = "id", insertable = false, updatable = false)
    private SensorLocation sensorLocation;
//    @Column(name = "sensors_locations_id")
    @JsonProperty
    @Column(name="sensors_locations_id")
    private long sensorsLocationsId;

    @JsonProperty("pm1")
    @Column(name = "pm1")
    private float pm1;

    @JsonProperty("pm25")
    @Column(name = "pm25")
    private float pm25;

    @CreationTimestamp
    @Column(name = "timestamp", updatable = false, nullable = false)
//    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp;

    public PmMeasurement() {
    }

    public PmMeasurement(long sensorLocationId, float pm1, float pm25) {
        this.sensorsLocationsId = sensorLocationId;
        this.pm1 = pm1;
        this.pm25 = pm25;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getSensorsLocationsId() {
        return sensorsLocationsId;
    }

    public void setSensorsLocationsId(int sensorsLocationsId) {
        this.sensorsLocationsId = sensorsLocationsId;
    }
    public float getPm1() {
        return pm1;
    }

    public void setPm1(float pm1) {
        this.pm1 = pm1;
    }

    public float getPm25() {
        return pm25;
    }

    public void setPm25(float pm25) {
        this.pm25 = pm25;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public SensorLocation getSensorLocation() {
        return sensorLocation;
    }

    public void setSensorLocation(SensorLocation sensorLocation) {
        this.sensorLocation = sensorLocation;
    }

    @Override
    public String toString() {
        return "PmMeasurement{" + "id=" + id + ", sensorLocation=" + sensorLocation+ ", sensorsLocationsId=" + sensorsLocationsId + ", pm1=" + pm1 + ", pm25=" + pm25 + ", timestamp=" + timestamp + '}';
    }


}
