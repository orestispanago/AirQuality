/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oop.services;

import com.oop.entities.Subscription;

/**
 *
 * @author petros_trak
 */
public interface ISubscriptionService {
    Subscription getById(long subscriptionId);
    Subscription update(Subscription subscription);;
    Subscription save(Subscription subscription);
    Subscription getByUserId(long userId);
    boolean existsById(long id);
}
