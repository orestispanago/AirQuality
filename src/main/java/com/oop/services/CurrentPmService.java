package com.oop.services;

import com.oop.dao.CurrentPmDaoImpl;
import com.oop.dao.ICurrentPmDao;
import com.oop.models.CurrentPm;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CurrentPmService implements ICurrentPmService {
    
    ICurrentPmDao currentPmDao = new CurrentPmDaoImpl();

    @Override
    public List<CurrentPm> getCurrentPmForAllSensors() {
        return currentPmDao.getCurrentPmforAllSensors();
    }

}
