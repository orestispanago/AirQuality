/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oop.services;

import com.oop.entities.Plan;
import java.util.List;

/**
 *
 * @author Walter
 */
public interface IPlanService {
    Plan getById(long planId);
    List<Plan> getAll();
    Plan save(Plan plan);
}
