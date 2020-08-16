package com.oop.controllers;

import com.oop.entities.SensorLocation;
import com.oop.dtos.UserSensorLocationDTO;
import com.oop.services.SensorLocationServiceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/sensorlocation")
public class SensorLocationController {

    @Autowired
    SensorLocationServiceImpl sensorLocationService;
    
    @GetMapping("/{username}")
    public List<UserSensorLocationDTO> getRegisteredSensorLocationsByUsername(@PathVariable String username){ //TODO add userId argument
        return sensorLocationService.getUserSensorLocations(username);
    }
    
    @PostMapping
    @ResponseStatus(CREATED)
    public SensorLocation saveSensorLocation(@RequestBody SensorLocation sl) {
        return sensorLocationService.save(sl);
    }

    @DeleteMapping
    @ResponseStatus(NO_CONTENT)
    public void deleteSensorLocation(@RequestBody SensorLocation sl) {
        sensorLocationService.delete(sl);
    }
    
}
