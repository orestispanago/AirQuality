package com.oop.services.interfaces;

import com.oop.dtos.SensorToRegisterDTO;
import com.oop.entities.SensorLocation;
import com.oop.dtos.UserSensorLocationDTO;
import java.util.List;


public interface ISensorLocationService{
    List<UserSensorLocationDTO>getUserSensorLocations(String username);
    SensorLocation save(SensorToRegisterDTO sensorToRegister);
    void deleteBySensorLocationId(long sensorLocationId);//make sure sensor measurements are deleted
}
