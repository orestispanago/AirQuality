package com.oop.dtos;


public class UserSensorLocationDTO {


    private String userId;
    private String registered;
    private String label;
    private String lat;
    private String lon;


    public UserSensorLocationDTO() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRegistered() {
        return registered;
    }

    public void setRegistered(String registered) {
        this.registered = registered;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
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

    @Override
    public String toString() {
        return "UserSensorLocation{" + "userId=" + userId + ", registered=" + registered + ", label=" + label + ", lat=" + lat + ", lon=" + lon + '}';
    }

    
}