package com.oop.dao;

import com.oop.entities.PmMeasurement;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPmMeasurementDao extends CrudRepository<PmMeasurement, Long> {

}
