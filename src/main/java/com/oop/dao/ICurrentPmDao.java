package com.oop.dao;

import com.oop.dtos.CurrentPmDTO;
import java.util.List;



public interface ICurrentPmDao {

    List<CurrentPmDTO> getCurrentPmforAllSensors();
}
