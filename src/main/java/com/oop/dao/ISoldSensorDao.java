package com.oop.dao;

import com.oop.entities.SoldSensor;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISoldSensorDao extends CrudRepository<SoldSensor, Long> {
    List<SoldSensor> findAllByUserId(long userId);
}
