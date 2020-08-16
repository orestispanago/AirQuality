package com.oop.dao;

import com.oop.entities.Subscription;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISubscriptionDao extends CrudRepository<Subscription, Long> {
    Subscription findByUserId(long userId);
    boolean existsByUserId(long userId);
}
