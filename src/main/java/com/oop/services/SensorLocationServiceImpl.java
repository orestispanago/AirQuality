package com.oop.services;

import com.oop.dao.ISensorLocationDao;
import com.oop.entities.SensorLocation;
import com.oop.exceptions.SensorLocationNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author orestis
 */
@Service
public class SensorLocationServiceImpl implements ISensorLocationService {

    @Autowired
    ISensorLocationDao sensorLocationDao;

    @Override
    public SensorLocation getById(long sensorLocationId) {
        return sensorLocationDao.findById(sensorLocationId).orElseThrow(SensorLocationNotFoundException::new);
    }

    @Override
    public SensorLocation save(SensorLocation sensorLocation) {
        if (sensorLocation != null) {
            return sensorLocationDao.save(sensorLocation);
        }
        return null;
    }

    @Override
    public void delete(SensorLocation sensorLocation) {
        if(!sensorLocationDao.existsById(sensorLocation.getId())) throw new SensorLocationNotFoundException();
        sensorLocationDao.delete(sensorLocation);
    }

}
