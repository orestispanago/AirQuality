/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oop.controllers;

import com.oop.entities.AppUser;
import com.oop.entities.Plan;
import com.oop.entities.Subscription;
import com.oop.exceptions.PlanNotFoundException;
import com.oop.exceptions.SubscriptionAlreadyExistsException;
import com.oop.exceptions.SubscriptionNotFoundException;
import com.oop.exceptions.UserNotFoundException;
import com.oop.services.IPlanService;
import com.oop.services.ISubscriptionService;
import com.oop.services.IUserService;
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
@RequestMapping("/subscriptions")
public class SubscriptionController {
    
    @Autowired
    ISubscriptionService subscriptionService;
    
    @Autowired
    IUserService userService;
    
    @Autowired
    IPlanService planService;
    
    @RequestMapping(value = "/{userId}", method = RequestMethod.GET, produces = "application/json")
    public Subscription readSubscriptionByUserId(@PathVariable long userId){
        if(userService.existsById(userId) == false) throw new UserNotFoundException();
        return subscriptionService.getById(userId);
    }
    
    @RequestMapping(value = "/{userId}", method = RequestMethod.POST, produces = "application/json")
    public Subscription createSubscriptionByUserId(@PathVariable long userId, long planId){
        if(userService.existsById(userId) == false) throw new UserNotFoundException();
        AppUser user = userService.getById(userId);
        if(!planService.existsById(planId)) throw new PlanNotFoundException();
        Plan plan = planService.getById(planId);
        if(subscriptionService.existsById(userId)) throw new SubscriptionAlreadyExistsException();
        Subscription subscription = new Subscription();
        subscription.setUser(user);
        subscription.setPlan(plan);
        return subscriptionService.save(subscription);
    }
    
    @RequestMapping(value = "/{userId}", method = RequestMethod.PUT, produces = "application/json")
    public Subscription updateSubscriptionByUserId(@PathVariable long userId, @RequestBody Subscription subscription){
        if(userService.existsById(userId) == false) throw new UserNotFoundException();
        long subscriptionId = subscription.getId();
        if(subscriptionService.existsById(subscriptionId) == false) throw new SubscriptionNotFoundException();
        return subscriptionService.save(subscription);
    }
}
