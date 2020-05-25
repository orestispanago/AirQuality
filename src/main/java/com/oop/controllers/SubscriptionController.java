/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oop.controllers;

import com.oop.dao.UserDao;
import com.oop.entities.AppUser;
import com.oop.entities.Subscription;
import com.oop.exceptions.SubscriptionAlreadyExistsException;
import com.oop.exceptions.SubscriptionNotFoundException;
import com.oop.exceptions.UserNotFoundException;
import com.oop.services.ISubscriptionService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author petros_trak
 */
@RestController
public class SubscriptionController {
    
    @Autowired
    ISubscriptionService subscriptionService;
    
    @Autowired
    UserDao userService;
    
    @RequestMapping(value = "{/userId}", method = RequestMethod.POST, produces = "application/json")
    public Subscription readSubscriptionByUserId(@PathVariable long userId){
        if(userService.existsById(userId)) throw new UserNotFoundException();
        return subscriptionService.getById(userId);
    }
    
    @RequestMapping(value = "{/userId}", method = RequestMethod.POST, produces = "application/json")
    public Subscription createSubscriptionByUserId(@PathVariable long userId){
        if(userService.existsById(userId) == false) throw new UserNotFoundException();
        Optional<AppUser> userEntity = userService.findById(userId);
        AppUser user = userEntity.get();
        if(subscriptionService.existsById(userId)) throw new SubscriptionAlreadyExistsException();
        Subscription subscription = new Subscription();
        subscription.setUser(user);
        return subscriptionService.save(subscription);
    }
    
    @RequestMapping(value = "{/userId}", method = RequestMethod.POST, produces = "application/json")
    public Subscription updateSubscriptionByUserId(@PathVariable long userId, @RequestBody Subscription subscription){
        if(userService.existsById(userId) == false) throw new UserNotFoundException();
        long subscriptionId = subscription.getId();
        if(subscriptionService.existsById(subscriptionId) == false) throw new SubscriptionNotFoundException();
        Subscription updateSubscription = subscriptionService.save(subscription);
        return updateSubscription;
    }
}
