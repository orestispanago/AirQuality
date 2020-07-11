package com.oop.services;

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

/**
 *
 * @author orestis
 */
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
    public List<SoldSensor> getAllByUserId(long userId){
        AppUser user = userService.getById(userId);
        return soldSensorDao.findAllByUserId(user.getId());
    }
    

    @Override
    public List<SoldSensor> getAllNonRegisteredByUserId(long userId) {
        AppUser user = userService.getById(userId);
        return soldSensorDao.findAllByUserIdAndRegisteredFalse(user.getId());
    }
    
    private Product getProductFromSoldSensor(SoldSensor soldSensor) {
        long productId = soldSensor.getProduct().getId();
        return productService.getById(productId);
    }

    private AppUser getUserFromSoldSensor(SoldSensor soldSensor) {
        long userId = soldSensor.getUser().getId();
        AppUser user = userDao.findById(userId).orElseThrow(UserNotFoundException::new);
        return user;
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
