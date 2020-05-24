package com.oop.dao;

import com.oop.entities.CoMeasurement;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICoMeasurementDao extends CrudRepository<CoMeasurement, Long> {

}
