package com.oop.services;

import com.oop.dao.ICoMeasurementDao;
import com.oop.entities.CoMeasurement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoMeasurementServiceImpl implements ICoMeasurementService {

    @Autowired
    ICoMeasurementDao coMeasurementDao;

    @Override
    public CoMeasurement save(CoMeasurement co) {
        return coMeasurementDao.save(co);
    }

}
