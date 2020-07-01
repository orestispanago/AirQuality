package com.oop.controllers;

import com.oop.entities.Plan;
import com.oop.services.IPlanService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/plans")
public class PlanController {
    @Autowired
    IPlanService planService;
     
    @GetMapping(value = "/{id}")
    public Plan readPlanById(@PathVariable long id) {
       return planService.getById(id);
    }
    
    @GetMapping
    public List<Plan> readAllPlans() {
       return planService.getAll();
    }
    
    @PostMapping
    public Plan save(@RequestBody Plan plan) {
       return planService.save(plan);
    }
}
