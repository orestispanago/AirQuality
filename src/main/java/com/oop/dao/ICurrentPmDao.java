package com.oop.dao;

import com.oop.models.CurrentPm;
import java.util.List;



public interface ICurrentPmDao {

    List<CurrentPm> getCurrentPmforAllSensors();
}
