/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oop.controllers;

import com.oop.entities.Plan;
import com.oop.services.IPlanService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Walter
 */
@RestController
@RequestMapping("/plans")
public class PlanController {
    @Autowired
    IPlanService planService;
     
    @GetMapping(value = "/{id}", produces = "application/json")
    public Plan readPlanById(@PathVariable long id) {
       return planService.getById(id);
    }
    
    @GetMapping(produces = "application/json")
    public List<Plan> readAllPlans() {
       return planService.getAll();
    }
    
    @PostMapping(produces = "application/json")
    public Plan save(@RequestBody Plan plan) {
       return planService.save(plan);
    }
}
