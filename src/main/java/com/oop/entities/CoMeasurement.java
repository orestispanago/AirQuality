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
@Table(name = "co_measurements")
public class CoMeasurement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne()
    @JoinColumn(name = "sensors_locations_id", referencedColumnName = "id", insertable = false, updatable = false)
    private SensorLocation sensorLocation;

    @JsonProperty("sensorsLocationsId")
    @Column(name = "sensors_locations_id")
    private long sensorsLocationsId;

    @JsonProperty("co")
    @Column(name = "co")
    private float co;

    @CreationTimestamp
    @Column(name = "timestamp", updatable = false, nullable = false)
    private Date timestamp;

    public CoMeasurement() {
    }

    public CoMeasurement(float pm1, float pm25) {
        this.co = co;
    }

    public long getId() {
        return id;
    }

    public SensorLocation getSensorLocation() {
        return sensorLocation;
    }

    public long getSensorsLocationsId() {
        return sensorsLocationsId;
    }

    public float getCo() {
        return co;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "CoMeasurement{" + "id=" + id + ", sensorLocation=" + sensorLocation + ", sensorsLocationsId=" + sensorsLocationsId + ", co=" + co + ", timestamp=" + timestamp + '}';
    }

}
