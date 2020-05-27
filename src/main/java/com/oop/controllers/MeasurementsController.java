package com.oop.controllers;

import com.oop.entities.CoMeasurement;
import com.oop.entities.PmMeasurement;
import com.oop.exceptions.SensorLocationNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.oop.entities.SensorLocation;
import com.oop.services.CoMeasurementServiceImpl;
import com.oop.services.PmMeasurementServiceImpl;
import com.oop.services.SensorLocationServiceImpl;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class MeasurementsController {

    @Autowired
    PmMeasurementServiceImpl pmService;

    @Autowired
    SensorLocationServiceImpl slService;

    @RequestMapping(value = "/pm/{sensorLocationId}", method = RequestMethod.POST, produces = "application/json")
    public PmMeasurement pmMeasurement(@PathVariable long sensorLocationId, @RequestBody PmMeasurement pm) throws Exception, SensorLocationNotFoundException {
        SensorLocation sl = slService.getById(sensorLocationId);
        pm.setSensorLocation(sl);
        pmService.save(pm);
        return pm;
    }

    @Autowired
    CoMeasurementServiceImpl coService;

    @RequestMapping(value = "/co/{sensorid}", method = RequestMethod.POST, produces = "application/json")
    public CoMeasurement coMeasurement(@PathVariable long sensorLocationId, @RequestBody CoMeasurement co) {
        SensorLocation sl = slService.getById(sensorLocationId);
        co.setSensorLocation(sl);
        coService.save(co);
        return co;
    }

}
