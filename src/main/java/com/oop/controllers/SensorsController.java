package com.oop.controllers;

import com.oop.entities.SensorLocation;
import com.oop.services.SensorLocationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sensor")
public class SensorsController {

    @Autowired
    SensorLocationServiceImpl sensorLocationlService;

    @PostMapping(value = "/sensorlocation", produces = "application/json")
    @ResponseStatus(CREATED)
    public SensorLocation saveSensorLocation(@RequestBody SensorLocation sl) {
        return sensorLocationlService.save(sl);
    }

    @DeleteMapping(value = "/sensorlocation", produces = "application/json")
    @ResponseStatus(NO_CONTENT)
    public void deleteSensorLocation(@RequestBody SensorLocation sl) {
        sensorLocationlService.delete(sl);
    }
    
}
