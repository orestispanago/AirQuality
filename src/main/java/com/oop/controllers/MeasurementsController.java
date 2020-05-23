package com.oop.controllers;

import com.oop.dao.CoMeasurementDao;
import com.oop.dao.ISubscriptionDao;
import com.oop.dao.PmMeasurementDao;
import com.oop.entities.CoMeasurement;
import com.oop.entities.PmMeasurement;
import com.oop.entities.Subscription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MeasurementsController {

    @Autowired
    PmMeasurementDao pmService;

    @RequestMapping(value="/pm", method=RequestMethod.POST, produces = "application/json")
    public String pmMeasurement(@RequestBody PmMeasurement pm) {
        pmService.saveAndFlush(pm);
        return "pm measurement saved!";
    }
    
    @Autowired
    CoMeasurementDao coService;

    @RequestMapping(value="/co", method=RequestMethod.POST, produces = "application/json")
    public String coMeasurement(@RequestBody CoMeasurement co) {
        coService.saveAndFlush(co);
        return "co measurement saved!";
    }
    
}
