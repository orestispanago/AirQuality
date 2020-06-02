package com.oop.controllers;

import com.oop.models.CurrentPm;
import com.oop.services.CurrentPmService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author orestis
 */
@RestController
@RequestMapping("/current")
public class CurrentController {
//    @Autowired
//    ICurrentPmDao currentPmDao;
//    
    @GetMapping(produces = "application/json")
    public CurrentPm getCurrentPm() {
       return CurrentPmService.getCurrent1();

 }
    
    
}
