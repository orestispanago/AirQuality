package com.oop.services;

import com.oop.dao.ISubscriptionDao;
import com.oop.dtos.SubscriptionDTO;
import com.oop.entities.AppUser;
import com.oop.entities.Plan;
import com.oop.entities.Subscription;
import com.oop.exceptions.SubscriptionAlreadyExistsException;
import com.oop.exceptions.SubscriptionNotFoundException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionServiceImpl implements ISubscriptionService {

    @Autowired
    ISubscriptionDao subscriptionDao;

    @Autowired
    IUserService userService;

    @Autowired
    IPlanService planService;

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
        if (sub == null) {
            throw new SubscriptionNotFoundException();
        }
        return sub;
    }

    public Subscription getByUsername(String username) {
        AppUser user = userService.getByUsername(username);
        Subscription sub = subscriptionDao.findByUserId(user.getId());
        if (sub == null) {
            throw new SubscriptionNotFoundException();
        }
        return sub;
    }

    @Override
    public Subscription update(long subscriptionId, SubscriptionDTO subDTO) {
        Plan plan = planService.getById(subDTO.getPlanId());
        Subscription dbSub = getById(subscriptionId);
        dbSub.setPlan(plan);
        dbSub = extendSubscriptionByNumOfMonths(dbSub, subDTO.getMonthsToExtend());
        return subscriptionDao.save(dbSub);
    }

    @Override
    public Subscription save(SubscriptionDTO subDTO) {
        String username = subDTO.getUsername();
        AppUser user = userService.getByUsername(username);
        if (existsByUserId(user.getId())) {
            throw new SubscriptionAlreadyExistsException();
        }
        Plan plan = planService.getById(subDTO.getPlanId());
        Subscription sub = new Subscription(plan, user);
        Subscription savedSubscription = subscriptionDao.save(sub);
        return savedSubscription;
    }

    @Override
    public boolean existsById(long id) {
        Subscription subscriptionEntity = subscriptionDao.findById(id).orElseGet(null);
        if (subscriptionEntity == null) {
            return false;
        }
        return true;
    }

    @Override
    public boolean existsByUserId(long id) {
        return subscriptionDao.existsByUserId(id);
    }

    private Subscription extendSubscriptionByNumOfMonths(Subscription subscription, int numOfMonths) {
        long monthMiliSeconds = 2629746000L;
        subscription.setExpirationDate(new Date(subscription.getExpirationDate().getTime() + (numOfMonths * monthMiliSeconds)));
        return subscription;
    }
    
    public Timestamp DateToTimestamp(Date dateToConvert) {
        return new Timestamp(dateToConvert.getTime());
    }
    
    public Date TimestampToDate(Timestamp tsToConvert) {
        return new Date(tsToConvert.getTime());
    }

}
