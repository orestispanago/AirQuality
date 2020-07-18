package com.oop.services.interfaces;

import com.oop.dtos.UserSensorNonRegisteredDTO;
import com.oop.entities.SoldSensor;
import java.util.List;


public interface ISoldSensorService {
    SoldSensor save(SoldSensor soldSensor);
    SoldSensor getById(long soldSensorId);
    List<UserSensorNonRegisteredDTO> getAllNonRegistered(String username);
    void delete(SoldSensor soldSensor);
}
