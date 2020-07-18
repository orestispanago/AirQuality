package com.oop.dao;

import com.oop.entities.SoldSensor;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISoldSensorDao extends JpaRepository<SoldSensor, Long> {
    List<SoldSensor> findAllByUserId(long userId);
    List<SoldSensor> findAllByUserIdAndRegisteredFalse(long userId);
}
