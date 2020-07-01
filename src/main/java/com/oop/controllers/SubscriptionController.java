package com.oop.controllers;

import com.oop.dtos.SubscriptionDTO;
import com.oop.entities.Subscription;
import com.oop.services.ISubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.http.HttpStatus.CREATED;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/subscriptions")
public class SubscriptionController {
    @Autowired
    ISubscriptionService subscriptionService;

    @GetMapping(value = "/users/{username}")
    public Subscription readSubscriptionByUsername(@PathVariable String username) {
        return subscriptionService.getByUsername(username);
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public Subscription createSubscriptionByUsername(@RequestBody SubscriptionDTO subDTO) {
        return subscriptionService.save(subDTO);
    }

    @PutMapping
    public Subscription updateSubscriptionByUserId(@RequestBody SubscriptionDTO subDTO) {
        return subscriptionService.update(subDTO);
    }
}
