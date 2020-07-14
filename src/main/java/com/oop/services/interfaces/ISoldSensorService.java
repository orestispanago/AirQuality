package com.oop.services.interfaces;

import com.oop.entities.SoldSensor;
import java.util.List;


public interface ISoldSensorService {
    SoldSensor save(SoldSensor soldSensor);
    SoldSensor getById(long soldSensorId);
    List<SoldSensor> getAllByUserId(long userId);
    List<SoldSensor> getAllNonRegisteredByUserId(long userId);
    void delete(SoldSensor soldSensor);
}
