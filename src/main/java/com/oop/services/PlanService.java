/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oop.services;

import com.oop.dao.IPlanDao;
import com.oop.entities.Plan;
import com.oop.exceptions.PlanNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Walter
 */
@Service
public class PlanService implements IPlanService {
    @Autowired
    IPlanDao planDao;
    
    @Override
    public Plan getById(long planId) {
        Plan plan = planDao.findById(planId).orElse(null);
        if (plan == null) throw new PlanNotFoundException();
        else return plan;
    }

    @Override
    public List<Plan> getAll() {
        return (List<Plan>) planDao.findAll();
    }

    @Override
    public Plan save(Plan plan) {
        if (plan != null){
            return planDao.save(plan);
        }
        return null;
    }

    @Override
    public boolean existsById(long planId) {
        return planDao.existsById(planId);
    }
    
}
