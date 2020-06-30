package com.oop.services;

import com.oop.entities.AppUser;
import com.oop.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.oop.dao.IUserDao;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    IUserDao userDao;

    @Override
    public AppUser getById(long userId) {
        return userDao.findById(userId).orElseThrow(()-> new UserNotFoundException());
    }

    @Override
    public String deleteById(long userId) {
        AppUser user = userDao.findById(userId).orElseThrow(()-> new UserNotFoundException());        
        userDao.delete(user);
        return user.getUsername();
    }
    
    public AppUser getByUsername(String username){
        AppUser user = userDao.findByUsername(username);
        if (user == null) throw new UserNotFoundException();
        return user;
    }
}
