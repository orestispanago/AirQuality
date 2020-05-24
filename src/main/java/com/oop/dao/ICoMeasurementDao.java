package com.oop.dao;

import com.oop.entities.CoMeasurement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICoMeasurementDao extends JpaRepository<CoMeasurement, Integer> {

}
