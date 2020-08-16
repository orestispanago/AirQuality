package com.oop.services;

import com.oop.services.interfaces.IProductService;
import com.oop.services.interfaces.ISoldSensorService;
import com.oop.services.interfaces.IUserService;
import com.oop.dao.ISoldSensorDao;
import com.oop.entities.AppUser;
import com.oop.entities.Product;
import com.oop.entities.SoldSensor;
import com.oop.exceptions.SoldSensorNotFoundException;
import com.oop.exceptions.UserNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.oop.dao.IUserDao;
import com.oop.dtos.UserSensorNonRegisteredDTO;
import java.util.ArrayList;

@Service
public class SoldSensorServiceImpl implements ISoldSensorService {

    @Autowired
    ISoldSensorDao soldSensorDao;

    @Autowired
    IUserService userService;

    @Autowired
    IProductService productService;

    @Autowired
    IUserDao userDao;

    @Override
    public SoldSensor getById(long soldSensorId) {
        return soldSensorDao.findById(soldSensorId).orElseThrow(SoldSensorNotFoundException::new);
    }

    @Override
    public List<UserSensorNonRegisteredDTO> getAllNonRegistered(String username) {
        long userId = userService.getByUsername(username).getId();
        List<SoldSensor> soldSensors = soldSensorDao.findAllByUserIdAndRegisteredFalse(userId);
        List<UserSensorNonRegisteredDTO> nonRegisteredDTOS = new ArrayList();
        for (SoldSensor soldSensor : soldSensors) {
            UserSensorNonRegisteredDTO nonRegisteredDTO = new UserSensorNonRegisteredDTO();
            nonRegisteredDTO.setUsername(username);
            nonRegisteredDTO.setSoldSensorId(soldSensor.getId());
            nonRegisteredDTO.setProductType(soldSensor.getProduct().getProductType().getType());
            nonRegisteredDTOS.add(nonRegisteredDTO);
        }
        return nonRegisteredDTOS;

    }

    private Product getProductFromSoldSensor(SoldSensor soldSensor) {
        long productId = soldSensor.getProduct().getId();
        return productService.getById(productId);
    }

    private AppUser getUserFromSoldSensor(SoldSensor soldSensor) {
        long userId = soldSensor.getUser().getId();
        return userDao.findById(userId).orElseThrow(UserNotFoundException::new);
    }

    @Override
    public SoldSensor save(SoldSensor soldSensor) {
        soldSensor.setProduct(getProductFromSoldSensor(soldSensor));
        soldSensor.setUser(getUserFromSoldSensor(soldSensor));
        return soldSensorDao.save(soldSensor);
    }

    @Override
    public void delete(SoldSensor soldSensor) {
        if (!soldSensorDao.existsById(soldSensor.getId())) {
            throw new SoldSensorNotFoundException();
        }
        soldSensor.setProduct(getProductFromSoldSensor(soldSensor));
        soldSensor.setUser(getUserFromSoldSensor(soldSensor));
        soldSensorDao.delete(soldSensor);

    }

}
