package com.oop.controllers;

import com.oop.entities.Plan;
import com.oop.services.interfaces.IPlanService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/plans")
public class PlanController {

    @Autowired
    IPlanService planService;

    @GetMapping(value = "/{planId}")
    public Plan readPlanById(@PathVariable long planId) {
        return planService.getById(planId);
    }

    @GetMapping
    public List<Plan> readAllPlans() {
        return planService.getAll();
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public Plan save(@RequestBody Plan plan) {
        return planService.save(plan);
    }
    
    @PutMapping(value = "/{planId}")
    public Plan update(@PathVariable long planId, @RequestBody Plan plan) {
        return planService.update(planId, plan);
    }

    @DeleteMapping(value = "/{planId}")
    @ResponseStatus(NO_CONTENT)
    public void deleteById(@PathVariable long planId){
        planService.deleteById(planId);
    }
}
