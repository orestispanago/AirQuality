package com.oop.controllers;

import com.oop.entities.AppUser;
import com.oop.services.ICartService;
import com.oop.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    IUserService userService;
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public AppUser readUserById(@PathVariable long id) {
        AppUser user = userService.getById(id);
        return user;
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public String deleteByUserId(@PathVariable long id) {
        String username = userService.deleteById(id);
        return "{\"outcome\": \"The user with username \"" + username + "\" was deleted successfully.\"}";
    }

    @RequestMapping(value = "/sensors", method = RequestMethod.GET, produces = "application/json")
    public String sensors() {
        return "List of all user's sensors";
    }

    @RequestMapping(value = "/sensors/{sensorid}/data", method = RequestMethod.POST, produces = "application/json")
    public String registerSensor() {
        return "Registered sensor";
    }

    @RequestMapping(value = "/sensors/{sensorid}", method = RequestMethod.DELETE, produces = "application/json")
    public String deleteSensor() {
        return "Deleted sensor";
    }

    @RequestMapping(value = "/carts", method = RequestMethod.GET, produces = "application/json")
    public String viewCart() {
        return "List of products in user's cart";
    }

    @RequestMapping(value = "/subscriptions", method = RequestMethod.GET, produces = "application/json")
    public String viewSubscriptions() {
        return "List of a user's subscriptions";
    }

    @RequestMapping(value = "/subscriptions", method = RequestMethod.POST, produces = "application/json")
    public String updateSubscriptions() {
        return "Updated a user's subscriptions";
    }

    @RequestMapping(value = "/subscriptions", method = RequestMethod.DELETE, produces = "application/json")
    public String cancelSubscription() {
        return "Subscription cancelled";
    }
    
}
