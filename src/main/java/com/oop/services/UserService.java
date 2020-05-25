/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oop.services;

import com.oop.dao.UserDao;
import com.oop.entities.AppUser;
import com.oop.exceptions.UserNotFoundException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Walter
 */
@Service
public class UserService implements IUserService {

    @Autowired
    UserDao userDao;

    @Override
    public AppUser getById(long userId) {
        Optional<AppUser> userEntity = userDao.findById(userId);
        if (userEntity == null) {
            throw new UserNotFoundException();
        } else {
            AppUser user = userEntity.get();
            return user;
        }
    }

    @Override
    public String deleteById(long userId) {
        Optional<AppUser> userEntity = userDao.findById(userId);
        if (userEntity == null) {
            throw new UserNotFoundException();
        } else {
            AppUser user = userEntity.get();
            String username = user.getUsername();
            userDao.delete(user);
            return username;
        }
    }
}
