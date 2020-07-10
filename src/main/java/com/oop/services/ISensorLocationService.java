package com.oop.services;

import com.oop.entities.SensorLocation;

/**
 *
 * @author orestis
 */
public interface ISensorLocationService {
    SensorLocation getById(long sensorLocationId);
    SensorLocation save(SensorLocation sensorLocation);
    void delete(SensorLocation sensorLocation);//make sure sensor measurements are deleted
}
