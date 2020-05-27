package com.oop.services;

import com.oop.entities.SensorLocation;

/**
 *
 * @author orestis
 */
public interface ISensorLocationService {
    SensorLocation getById(long sensorLocationId);
}
