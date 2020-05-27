package com.oop.controllers;

import com.oop.dao.ISensorLocationDao;
import com.oop.dao.ISoldSensorDao;
import com.oop.entities.SensorLocation;
import com.oop.entities.SoldSensor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sensor")
public class SensorsController {

    @Autowired
    ISensorLocationDao slService;

    @RequestMapping(value = "/sensorlocation", method = RequestMethod.POST, produces = "application/json")
    public SensorLocation sensorLocation(@RequestBody SensorLocation sl) {
        slService.save(sl);
        return sl;
    }

    @Autowired
    ISoldSensorDao ssService;

    @RequestMapping(value = "/soldsensoruser", method = RequestMethod.POST, produces = "application/json")
    public String soldSensorUser(@RequestBody SoldSensor ss) {
        ssService.save(ss);
        return ss + " saved!";
    }

}
