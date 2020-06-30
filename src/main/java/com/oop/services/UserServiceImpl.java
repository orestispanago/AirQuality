/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oop.services;

import com.oop.dao.UserDao;
import com.oop.entities.AppUser;
import com.oop.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Walter
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    UserDao userDao;

    @Override
    public AppUser getById(long userId) {
        return userDao.findById(userId).orElseThrow(UserNotFoundException::new);
    }

    @Override
    public String deleteById(long userId) {
        AppUser user = userDao.findById(userId).orElse(null);
        if (user == null) throw new UserNotFoundException();
        String username = user.getUsername();
        userDao.delete(user);
        return username;
    }
}
