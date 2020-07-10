package com.oop.controllers;

import com.oop.entities.SoldSensor;
import com.oop.services.ISoldSensorService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/soldsensoruser")
public class SoldSensorsController {

    @Autowired
    ISoldSensorService soldSensorService;
    
    @GetMapping(value = "/{userId}", produces = "application/json")
    public List<SoldSensor> getAllSoldSensorUser(@PathVariable long userId) {
        return soldSensorService.getAllByUserId(userId);
    }
    
    @PostMapping(produces = "application/json")
    @ResponseStatus(CREATED)
    public SoldSensor saveSoldSensorUser(@RequestBody SoldSensor ss) {
        return soldSensorService.save(ss);
    }
    
    @DeleteMapping(produces = "application/json")
    @ResponseStatus(NO_CONTENT)
    public void deleteSoldSensorUser(@RequestBody SoldSensor ss) {
        soldSensorService.delete(ss);
    }
}
