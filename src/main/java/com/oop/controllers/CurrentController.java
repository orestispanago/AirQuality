package com.oop.controllers;

import com.oop.models.CurrentPm;
import com.oop.services.ICurrentPmService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3001")
@RequestMapping("/current")
public class CurrentController {
    
    @Autowired
    ICurrentPmService currentPmService;
  
    @GetMapping(produces = "application/json")
    public List<CurrentPm> getCurrentPm() {
       return currentPmService.getCurrentPmForAllSensors();
    }
}
