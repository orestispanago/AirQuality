package com.oop.services;

import com.oop.dao.UserSensorLocationsDaoImpl;
import com.oop.services.interfaces.ISensorLocationService;
import com.oop.dao.ISensorLocationDao;
import com.oop.dao.ISoldSensorDao;
import com.oop.entities.AppUser;
import com.oop.entities.SensorLocation;
import com.oop.entities.SoldSensor;
import com.oop.exceptions.SensorLocationNotFoundException;
import com.oop.exceptions.SoldSensorNotFoundException;
import com.oop.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.oop.dao.IUserDao;
import com.oop.dao.IUserSensorLocationDao;
import com.oop.dtos.UserSensorLocationDTO;
import java.util.List;


@Service
public class SensorLocationServiceImpl implements ISensorLocationService {

    @Autowired
    ISensorLocationDao sensorLocationDao;

    @Autowired
    ISoldSensorDao soldSensorDao;

    @Autowired
    IUserDao userDao;
    
    IUserSensorLocationDao userSensorLocationDao = new UserSensorLocationsDaoImpl();

    @Override
    public SensorLocation getById(long sensorLocationId) {
        return sensorLocationDao.findById(sensorLocationId).orElseThrow(SensorLocationNotFoundException::new);
    }

    private AppUser getUserFromSoldSensor(SoldSensor soldSensor) {
        long userId = soldSensor.getUser().getId();
        return userDao.findById(userId).orElseThrow(UserNotFoundException::new);
    }

    @Override
    public SensorLocation save(SensorLocation sensorLocation) {
        SoldSensor soldSensor = sensorLocation.getSoldSensor();
        soldSensor = soldSensorDao.findById(soldSensor.getId()).orElseThrow(SoldSensorNotFoundException::new);
        soldSensor.setUser(getUserFromSoldSensor(soldSensor));
        soldSensor.setRegistered(true);
        sensorLocation.setSoldSensor(soldSensor);
        return sensorLocationDao.save(sensorLocation);
    }

    @Override
    public void delete(SensorLocation sensorLocation) {
        if (!sensorLocationDao.existsById(sensorLocation.getId())) {
            throw new SensorLocationNotFoundException();
        }
        sensorLocationDao.delete(sensorLocation);
    }

    @Override
    public List<UserSensorLocationDTO> getUserSensorLocations(long userId) {
        return userSensorLocationDao.getUserSensorLocations(userId);
    }



}
