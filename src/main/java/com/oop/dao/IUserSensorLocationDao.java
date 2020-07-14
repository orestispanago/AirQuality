package com.oop.dao;

import com.oop.dtos.UserSensorLocationDTO;
import java.util.List;

public interface IUserSensorLocationDao {
    List<UserSensorLocationDTO> getUserSensorLocations(long userId);
}
