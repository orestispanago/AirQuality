package com.oop.controllers;

import com.oop.entities.AppUser;
import com.oop.entities.Plan;
import com.oop.entities.Subscription;
import com.oop.exceptions.SubscriptionAlreadyExistsException;
import com.oop.services.IPlanService;
import com.oop.services.ISubscriptionService;
import com.oop.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


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
    public Subscription readSubscriptionByUserId(@PathVariable long userId) {
        AppUser user = userService.getById(userId);
        return subscriptionService.getById(user.getId());
    }

    @RequestMapping(value = "/{userId}/{planId}", method = RequestMethod.POST, produces = "application/json")
    public Subscription createSubscriptionByUserId(@PathVariable long userId, @PathVariable long planId) {
        AppUser user = userService.getById(userId);
        Plan plan = planService.getById(planId);
        if (subscriptionService.existsByUserId(userId)) {
            throw new SubscriptionAlreadyExistsException();
        }
        Subscription sub = new Subscription(plan, user);
        return subscriptionService.save(sub);
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.PUT, produces = "application/json")
    public Subscription updateSubscriptionByUserId(@PathVariable long userId, @RequestBody Subscription subscription) {
        AppUser user = userService.getById(userId);
        Subscription sub = subscriptionService.getByUserId(userId);
        return subscriptionService.save(subscription);
    }
}
