package com.oop.services;

import com.oop.entities.SensorLocation;
import com.oop.models.UserSensorLocation;
import java.util.List;

/**
 *
 * @author orestis
 */
public interface ISensorLocationService{
    SensorLocation getById(long sensorLocationId);
    List<UserSensorLocation>getUserSensorLocations();
    SensorLocation save(SensorLocation sensorLocation);
    void delete(SensorLocation sensorLocation);//make sure sensor measurements are deleted
}
