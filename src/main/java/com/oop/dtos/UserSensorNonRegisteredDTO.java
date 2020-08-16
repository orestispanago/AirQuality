package com.oop.dtos;


public class UserSensorNonRegisteredDTO {
    
    private String username;
    private String productType;
    private long soldSensorId;

    public UserSensorNonRegisteredDTO() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public long getSoldSensorId() {
        return soldSensorId;
    }

    public void setSoldSensorId(long soldSensorId) {
        this.soldSensorId = soldSensorId;
    }

    @Override
    public String toString() {
        return "UserSenrorNonRegistered{" + "username=" + username + ", productType=" + productType + ", soldSensorId=" + soldSensorId + '}';
    }
    
    
    
}
