package com.oop.dao;

import com.oop.entities.SensorLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISensorLocationDao extends JpaRepository<SensorLocation, Long> {
//    @Query("select sl from SensorLocation sl where sl.SoldSensor.User.Id=?1")
//    List<SensorLocation> findAllBySoldSensorAndUserId(long userId);
}
