package com.oop.dao;

import com.oop.entities.PmMeasurement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PmMeasurementDao extends JpaRepository<PmMeasurement, Integer> {

}
