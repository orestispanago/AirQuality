package com.oop.dtos;


public class UserSensorLocationDTO {


    private long userId;
    private long sensorLocationId;
    private boolean registered;
    private String label;
    private float lat;
    private float lon;


    public UserSensorLocationDTO() {
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getSensorLocationId() {
        return sensorLocationId;
    }

    public void setSensorLocationId(long sensorLocationId) {
        this.sensorLocationId = sensorLocationId;
    }

    public boolean isRegistered() {
        return registered;
    }

    public void setRegistered(boolean registered) {
        this.registered = registered;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
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



    @Override
    public String toString() {
        return "UserSensorLocation{" + "userId=" + userId + ", registered=" + registered + ", label=" + label + ", lat=" + lat + ", lon=" + lon + '}';
    }

    
}