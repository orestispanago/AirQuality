/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oop.services;

import com.oop.dao.ISubscriptionDao;
import com.oop.entities.Subscription;
import com.oop.exceptions.SubscriptionNotFoundException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author petros_trak
 */
@Service
public class SubscriptionServiceImpl implements ISubscriptionService{

    @Autowired
    ISubscriptionDao subscriptionService;
    
    @Override
    public Subscription getById(long subscriptionId) {
        Optional<Subscription> subEntity = subscriptionService.findById(subscriptionId);
        if(subEntity == null)
            throw new SubscriptionNotFoundException();
        else{
            Subscription sub = subEntity.get();
            return sub;
        }
    }

    @Override
    public Subscription update(Subscription subscription) {
        Subscription dbSub = subscriptionService.findById(subscription.getId()).orElse(null);
        if(dbSub == null) throw new SubscriptionNotFoundException();
        return subscriptionService.save(subscription);
    }
    
}
