package com.oop.controllers;

import Test.Greeting;
import com.oop.dao.CoMeasurementDao;
import com.oop.dao.PmMeasurementDao;
import com.oop.dao.UserDao;
import com.oop.entities.AppUser;
import com.oop.entities.CoMeasurement;
import com.oop.entities.PmMeasurement;
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
public class HelloWorldController {

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
