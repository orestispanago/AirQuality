package com.oop.controllers;

import com.oop.entities.CoMeasurement;
import com.oop.entities.PmMeasurement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.oop.services.CoMeasurementServiceImpl;
import com.oop.services.PmMeasurementServiceImpl;
import com.oop.services.SensorLocationServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
public class MeasurementsController {

    @Autowired
    PmMeasurementServiceImpl pmService;

    @Autowired
    SensorLocationServiceImpl slService;

    @Autowired
    CoMeasurementServiceImpl coService;
    
    @PostMapping(value = "/pm", produces = "application/json")
    public PmMeasurement pmMeasurement(@RequestBody PmMeasurement pm){
        return pmService.save(pm);
    }


    @PostMapping(value = "/co", produces = "application/json")
    public CoMeasurement coMeasurement(@RequestBody CoMeasurement co) {
        return coService.save(co);
    }

}
