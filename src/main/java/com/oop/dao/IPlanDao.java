package com.oop.dao;

import com.oop.entities.Plan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPlanDao extends CrudRepository<Plan, Long> {

}