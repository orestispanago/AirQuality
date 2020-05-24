package com.oop.controllers;

import Test.Greeting;
import com.oop.dao.ISensorLocationDao;
import com.oop.dao.ISoldSensorDao;
import com.oop.dao.ISubscriptionDao;
import com.oop.dao.UserDao;
import com.oop.entities.AppUser;
import com.oop.entities.SensorLocation;
import com.oop.entities.SoldSensor;
import com.oop.entities.Subscription;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @RequestMapping({"/"})
    public String landingPage() {
        return "This is the landing page";
    }

    @RequestMapping({"/products"})
    public String products() {
        return "Products, shop or whateva";
    }

    @RequestMapping({"/map"})
    public String map() {
        return "Here is a map for everyone";
    }

//    @RequestMapping({"/hello"})
//    public String firstPage() {
//        return "Hello World";
//    }
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @Autowired
    UserDao userService;

    @GetMapping(path = "/user/{id}", produces = "application/json")
    public Optional<AppUser> read(@PathVariable int id) {
        return userService.findById(id);
    }

    @Autowired
    ISubscriptionDao subService;

    @RequestMapping(value = "/subscription", method = RequestMethod.POST, produces = "application/json")
    public String subscription(@RequestBody Subscription sub) {
        System.out.println(sub);
        subService.save(sub);
        return sub+" saved!";
    }
    @Autowired
    ISensorLocationDao slService;
    

    @RequestMapping(value = "/sensorlocation", method = RequestMethod.POST, produces = "application/json")
    public String sensorLocation(@RequestBody SensorLocation sl) {
        slService.save(sl);
        return sl+" saved!";
    }
    
    @Autowired
    ISoldSensorDao ssService;
    
    @RequestMapping(value = "/soldsensoruser", method = RequestMethod.POST, produces = "application/json")
    public String soldSensorUser(@RequestBody SoldSensor ss) {
        ssService.save(ss);
        return ss+" saved!";
    }
        
}
