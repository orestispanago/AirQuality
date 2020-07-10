package com.oop.models;

/**
 *
 * @author orestis
 */
public class CurrentPm {

    private String timestamp;
    private String pm1;
    private String pm25;
    private String lat;
    private String lon;
    private String sensorId;

    public CurrentPm() {
    }

    public CurrentPm(String timestamp, String pm1, String pm25, String lat, String lon, String sensorId) {
        this.timestamp = timestamp;
        this.pm1 = pm1;
        this.pm25 = pm25;
        this.lat = lat;
        this.lon = lon;
        this.sensorId = sensorId;
    }



    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getPm1() {
        return pm1;
    }

    public void setPm1(String pm1) {
        this.pm1 = pm1;
    }

    public String getPm25() {
        return pm25;
    }

    public void setPm25(String pm25) {
        this.pm25 = pm25;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public String getSensorId() {
        return sensorId;
    }

    public void setSensorId(String sensorId) {
        this.sensorId = sensorId;
    }



    @Override
    public String toString() {
        return "CurrentPm{" + "timestamp=" + timestamp + ", pm1=" + pm1 + ", pm25=" + pm25 + ", lat=" + lat + ", lon=" + lon + ", sensorId=" + sensorId + '}';
    }


    
}