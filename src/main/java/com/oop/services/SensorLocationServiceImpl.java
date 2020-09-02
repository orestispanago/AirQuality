package com.oop.services;

import com.oop.dao.UserSensorLocationsDaoImpl;
import com.oop.services.interfaces.ISensorLocationService;
import com.oop.dao.ISensorLocationDao;
import com.oop.entities.SensorLocation;
import com.oop.entities.SoldSensor;
import com.oop.exceptions.SensorLocationNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.oop.dao.IUserDao;
import com.oop.dao.IUserSensorLocationDao;
import com.oop.dtos.SensorToRegisterDTO;
import com.oop.dtos.UserSensorLocationDTO;
import com.oop.services.interfaces.ISoldSensorService;
import com.oop.services.interfaces.IUserService;
import java.util.List;

@Service
public class SensorLocationServiceImpl implements ISensorLocationService {

    @Autowired
    IUserService userService;

    @Autowired
    ISensorLocationDao sensorLocationDao;

    @Autowired
    ISoldSensorService soldSensorService;

    @Autowired
    IUserDao userDao;

    IUserSensorLocationDao userSensorLocationDao = new UserSensorLocationsDaoImpl();


    @Override
    public SensorLocation save(SensorToRegisterDTO sensorToRegister) {
        long soldSensorId = sensorToRegister.getSoldSensorId();
        SoldSensor soldSensor = soldSensorService.getById(soldSensorId);
        soldSensor.setRegistered(true);
        SensorLocation sensorLocation = new SensorLocation();
        sensorLocation.setSoldSensor(soldSensor);
        sensorLocation.setLabel(sensorToRegister.getLabel());
        sensorLocation.setLat(sensorToRegister.getLat());
        sensorLocation.setLon(sensorToRegister.getLon());
        return sensorLocationDao.save(sensorLocation);
    }

    @Override
    public List<UserSensorLocationDTO> getUserSensorLocations(String username) {
        long userId = userService.getByUsername(username).getId();
        return userSensorLocationDao.getUserSensorLocations(userId);
    }

    @Override
    public void delete(UserSensorLocationDTO userSensorLocation) {
        long sensorLocationId = userSensorLocation.getSensorLocationId();
        SensorLocation sensorLocation = sensorLocationDao.findById(sensorLocationId).orElseThrow(SensorLocationNotFoundException::new);;
        sensorLocation.getSoldSensor().setRegistered(false);
        sensorLocationDao.delete(sensorLocation);
    }



}
