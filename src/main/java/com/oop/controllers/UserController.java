package com.oop.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author orestis
 */
@RestController
@RequestMapping("/user/{id}")
public class UserController {

    // /user/sensor/data
    // /user/sensor/register
    // /user/sensor/delete
    @RequestMapping(value = "/sensors", method = RequestMethod.GET, produces = "application/json")
    public String sensors() {
        return "List of all user's sensors";
    }

    @RequestMapping(value = "/sensor/{sensorid}/data", method = RequestMethod.POST, produces = "application/json")
    public String registerSensor() {
        return "Registered sensor";
    }

    @RequestMapping(value = "/sensor/{sensorid}", method = RequestMethod.DELETE, produces = "application/json")
    public String deleteSensor() {
        return "Deleted sensor";
    }

    @RequestMapping(value = "/cart", method = RequestMethod.GET, produces = "application/json")
    public String viewCart() {
        return "List of products in user's cart";
    }

    @RequestMapping(value = "/cart", method = RequestMethod.POST, produces = "application/json")
    public String updateCart() {
        return "Updated Cart";
    }

    @RequestMapping(value = "/cart", method = RequestMethod.DELETE, produces = "application/json")
    public String emptyCart() {
        return "Emptied Cart";
    }

}
