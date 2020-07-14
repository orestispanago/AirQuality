package com.oop.services.interfaces;

import com.oop.entities.Plan;
import java.util.List;

public interface IPlanService {
    Plan getById(long planId);
    List<Plan> getAll();
    Plan save(Plan plan);
    boolean existsById(long planId);
    Plan update(long planId, Plan plan);
    void deleteById(long planId);
}
