package com.oop.services;

import com.oop.models.CurrentPm;
import java.sql.ResultSet;
import java.util.List;


public interface ICurrentPmService {
    List<CurrentPm> getCurrentPmForAllSensors();
}
