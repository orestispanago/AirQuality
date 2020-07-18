package com.oop.services.interfaces;

import com.oop.dtos.CurrentPmDTO;
import java.util.List;


public interface ICurrentPmService {
    List<CurrentPmDTO> getCurrentPmForAllSensors();
}
