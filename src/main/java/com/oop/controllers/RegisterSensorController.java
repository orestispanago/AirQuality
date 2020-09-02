package com.oop.controllers;

import com.oop.dtos.SensorToRegisterDTO;
import com.oop.entities.SensorLocation;
import com.oop.services.interfaces.ISensorLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.http.HttpStatus.CREATED;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/sensor-registration")
public class RegisterSensorController {

    @Autowired
    ISensorLocationService sensorLocationService;
    
    
    @PostMapping
    @ResponseStatus(CREATED)
    public SensorLocation save(@RequestBody SensorToRegisterDTO sensorToRegister) {
        return sensorLocationService.save(sensorToRegister);
    }

}
