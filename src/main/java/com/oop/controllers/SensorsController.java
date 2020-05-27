package com.oop.controllers;

import com.oop.dao.ISensorLocationDao;
import com.oop.dao.ISoldSensorDao;
import com.oop.entities.SensorLocation;
import com.oop.entities.SoldSensor;
import com.oop.services.SensorLocationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sensor")
public class SensorsController {

    @Autowired
    SensorLocationServiceImpl sensorLocationlService;

    @RequestMapping(value = "/sensorlocation", method =POST, produces = "application/json")
    public SensorLocation sensorLocation(@RequestBody SensorLocation sl) {
        return sensorLocationlService.save(sl);
    }

    @Autowired
    ISoldSensorDao ssService;

    @RequestMapping(value = "/soldsensoruser", method = POST, produces = "application/json")
    public SoldSensor soldSensorUser(@RequestBody SoldSensor ss) {
        return ssService.save(ss);
    }

}
