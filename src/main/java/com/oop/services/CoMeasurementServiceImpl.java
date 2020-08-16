package com.oop.services;

import com.oop.services.interfaces.ICoMeasurementService;
import com.oop.dao.ICoMeasurementDao;
import com.oop.dao.ISensorLocationDao;
import com.oop.dao.ISoldSensorDao;
import com.oop.entities.CoMeasurement;
import com.oop.entities.SensorLocation;
import com.oop.entities.SoldSensor;
import com.oop.exceptions.SensorLocationNotFoundException;
import com.oop.exceptions.SoldSensorNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoMeasurementServiceImpl implements ICoMeasurementService {

    @Autowired
    ICoMeasurementDao coMeasurementDao;

    @Autowired
    ISensorLocationDao sensorLocationDao;

    @Autowired
    ISoldSensorDao soldSensorDao;

    @Override
    public CoMeasurement save(CoMeasurement co) {
        SensorLocation sensorLocation = co.getSensorLocation();
        sensorLocation = sensorLocationDao.findById(sensorLocation.getId()).orElseThrow(SensorLocationNotFoundException::new);
        SoldSensor soldSensor = sensorLocation.getSoldSensor();
        long soldSensorId;
        try {
            soldSensorId = soldSensor.getId();
        } catch (java.lang.NullPointerException e) {
            throw new SoldSensorNotFoundException();
        }
        soldSensor = soldSensorDao.findById(soldSensorId).orElseThrow(SoldSensorNotFoundException::new);
        sensorLocation.setSoldSensor(soldSensor);
        co.setSensorLocation(sensorLocation);
        return coMeasurementDao.save(co);
    }

}
