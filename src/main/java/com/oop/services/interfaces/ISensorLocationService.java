package com.oop.services.interfaces;

import com.oop.dtos.SensorToRegisterDTO;
import com.oop.entities.SensorLocation;
import com.oop.dtos.UserSensorLocationDTO;
import java.util.List;


public interface ISensorLocationService{
    SensorLocation getById(long sensorLocationId);
    List<UserSensorLocationDTO>getUserSensorLocations(String username);
    SensorLocation save(SensorToRegisterDTO sensorToRegister);
    void delete(SensorLocation sensorLocation);//make sure sensor measurements are deleted
}
