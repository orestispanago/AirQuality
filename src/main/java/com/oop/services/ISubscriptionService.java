/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oop.services;

import com.oop.dtos.SubscriptionDTO;
import com.oop.entities.Subscription;

/**
 *
 * @author petros_trak
 */
public interface ISubscriptionService {
    Subscription getById(long subscriptionId);
    Subscription update(SubscriptionDTO subscriptionDTO);
    Subscription save(SubscriptionDTO subscriptionDTO);
    Subscription getByUserId(long userId);
    boolean existsByUserId(long id);
    boolean existsById(long id);
    Subscription getByUsername(String username);
}
