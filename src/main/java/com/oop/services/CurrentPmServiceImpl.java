package com.oop.services;

import com.oop.services.interfaces.ICurrentPmService;
import com.oop.dao.CurrentPmDaoImpl;
import com.oop.dao.ICurrentPmDao;
import com.oop.dtos.CurrentPmDTO;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CurrentPmServiceImpl implements ICurrentPmService {
    
    ICurrentPmDao currentPmDao = new CurrentPmDaoImpl();

    @Override
    public List<CurrentPmDTO> getCurrentPmForAllSensors() {
        return currentPmDao.getCurrentPmforAllSensors();
    }

}
