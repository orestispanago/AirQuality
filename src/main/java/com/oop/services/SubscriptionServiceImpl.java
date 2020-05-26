/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oop.services;

import com.oop.dao.ISubscriptionDao;
import com.oop.entities.AppUser;
import com.oop.entities.Subscription;
import com.oop.exceptions.SubscriptionNotFoundException;
import com.oop.exceptions.UserNotFoundException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author petros_trak
 */
@Service
public class SubscriptionServiceImpl implements ISubscriptionService {

    @Autowired
    ISubscriptionDao subscriptionDao;

    @Override
    public Subscription getById(long subscriptionId) {
        Optional<Subscription> subEntity = subscriptionDao.findById(subscriptionId);
        if (subEntity == null) {
            throw new SubscriptionNotFoundException();
        } else {
            Subscription sub = subEntity.get();
            return sub;
        }
    }
    
    @Override
    public Subscription getByUserId(long userId) {
        Subscription sub = subscriptionDao.findByUserId(userId);
        if (sub == null) throw new SubscriptionNotFoundException();
        return sub;
    }

    @Override
    public Subscription update(Subscription subscription) {
        Subscription dbSub = subscriptionDao.findById(subscription.getId()).orElse(null);
        if (dbSub == null) {
            throw new SubscriptionNotFoundException();
        }
        return subscriptionDao.save(subscription);
    }

    @Override
    public Subscription save(Subscription subscription) {
        if (subscription != null) {
            Subscription savedSubscription = subscriptionDao.save(subscription);
            return savedSubscription;
        }
        return null;
    }

    @Override
    public boolean existsById(long id) {
        Optional<Subscription> subscriptionEntity = subscriptionDao.findById(id);
        if (subscriptionEntity == null) {
            return false;
        }
        return true;
    }

    @Override
    public boolean existsByUserId(long id) {
        return subscriptionDao.existsByUserId(id);
    }

    

}
