package com.oop.dao;

import com.oop.entities.SensorLocation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISensorLocationDao extends CrudRepository<SensorLocation, Long> {

    SensorLocation findById(long id);
}
