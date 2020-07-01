package com.oop.services;

import com.oop.dao.IPlanDao;
import com.oop.entities.Plan;
import com.oop.exceptions.PlanNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlanServiceImpl implements IPlanService {
    @Autowired
    IPlanDao planDao;
    
    @Override
    public Plan getById(long planId) {
        return planDao.findById(planId).orElseThrow(()-> new PlanNotFoundException());
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

    @Override
    public Plan update(long planId, Plan plan) {
        Plan dbPlan = getById(planId);
        dbPlan.setDescription(plan.getDescription());
        dbPlan.setFeature1(plan.getFeature1());
        dbPlan.setFeature2(plan.getFeature2());
        dbPlan.setFeature3(plan.getFeature3());
        dbPlan.setLabel(plan.getLabel());
        dbPlan.setPricePerMonth(plan.getPricePerMonth());
        dbPlan.setTitle(plan.getTitle());
        return planDao.save(dbPlan);
    }

    @Override
    public void deleteById(long planId) {
        Plan plan = getById(planId);
        planDao.delete(plan);
    }
}
