package com.oop.controllers;

import com.oop.dao.ISensorLocationDao;
import com.oop.entities.CoMeasurement;
import com.oop.entities.PmMeasurement;
import com.oop.exceptions.SensorLocationIdDoesNotExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.oop.dao.ICoMeasurementDao;
import com.oop.dao.IPmMeasurementDao;
import com.oop.entities.SensorLocation;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class MeasurementsController {

    @Autowired
    IPmMeasurementDao pmService;

    @Autowired
    ISensorLocationDao slService;

    @RequestMapping(value = "/pm/{sensorLocationId}", method = RequestMethod.POST, produces = "application/json")
    public PmMeasurement pmMeasurement(@PathVariable long sensorLocationId,@RequestBody PmMeasurement pm) throws Exception, SensorLocationIdDoesNotExistException {
        SensorLocation sl = slService.findById(sensorLocationId);
        if (sl == null) throw new SensorLocationIdDoesNotExistException(sensorLocationId);
        pm.setSensorLocation(sl);
        pmService.save(pm);
        return pm;
    }

    @Autowired
    ICoMeasurementDao coService;

    @RequestMapping(value = "/co/{sensorid}", method = RequestMethod.POST, produces = "application/json")
    public CoMeasurement coMeasurement(@PathVariable long sensorid, @RequestBody CoMeasurement co) {
        SensorLocation sl = slService.findById(sensorid);
        if (sl == null) {
            throw new SensorLocationIdDoesNotExistException(sensorid);
        } else {
            co.setSensorLocation(sl);
            coService.save(co);
            return co;
        }
    }

}
