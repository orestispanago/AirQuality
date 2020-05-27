package com.oop.services;

import com.oop.dao.IPmMeasurementDao;
import com.oop.entities.PmMeasurement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PmMeasurementServiceImpl implements IPmMeasurementService {

    @Autowired
    IPmMeasurementDao pmDao;

    @Override
    public PmMeasurement save(PmMeasurement pm) {
        return pmDao.save(pm);
    }

}
