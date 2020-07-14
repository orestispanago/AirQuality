package com.oop.services.interfaces;

import com.oop.entities.SensorLocation;
import com.oop.dtos.UserSensorLocationDTO;
import java.util.List;

/**
 *
 * @author orestis
 */
public interface ISensorLocationService{
    SensorLocation getById(long sensorLocationId);
    List<UserSensorLocationDTO>getUserSensorLocations(long userId);
    SensorLocation save(SensorLocation sensorLocation);
    void delete(SensorLocation sensorLocation);//make sure sensor measurements are deleted
}
