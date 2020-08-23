package com.oop.dtos;


public class SensorToRegisterDTO {


    private long soldSensorId;
    private String label;
    private float lat;
    private float lon;

    public SensorToRegisterDTO() {
    }

    public long getSoldSensorId() {
        return soldSensorId;
    }

    public void setSoldSensorId(long soldSensorId) {
        this.soldSensorId = soldSensorId;
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
        return "SensorToRegister{soldSensorId=" + soldSensorId + ", label=" + label + ", lat=" + lat + ", lon=" + lon + '}';
    }


    
}