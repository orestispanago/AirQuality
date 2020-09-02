package com.oop.dtos;

import java.util.Date;

public class CurrentPmDTO{

    private long id;
    private Date timestamp;
    private float pm1;
    private float pm25;
    private float lat;
    private float lon;
    private long sensorId;

    public CurrentPmDTO() {
    }

    public CurrentPmDTO(long id, Date timestamp, float pm1, float pm25, float lat, float lon, long sensorId) {
        this.id = id;
        this.timestamp = timestamp;
        this.pm1 = pm1;
        this.pm25 = pm25;
        this.lat = lat;
        this.lon = lon;
        this.sensorId = sensorId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
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

    public long getSensorId() {
        return sensorId;
    }

    public void setSensorId(long sensorId) {
        this.sensorId = sensorId;
    }

    @Override
    public String toString() {
        return "CurrentPmDTO{" + "id=" + id + ", timestamp=" + timestamp + ", pm1=" + pm1 + ", pm25=" + pm25 + ", lat=" + lat + ", lon=" + lon + ", sensorId=" + sensorId + '}';
    }


}
