package com.oop.services;

import com.oop.entities.AppUser;
import com.oop.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.oop.dao.IUserDao;
import static org.springframework.http.HttpStatus.NO_CONTENT;
import org.springframework.web.bind.annotation.ResponseStatus;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    IUserDao userDao;

    @Override
    public AppUser getById(long userId) {
        return userDao.findById(userId).orElseThrow(()-> new UserNotFoundException());
    }

    @Override
    @ResponseStatus(NO_CONTENT)
    public String deleteById(long userId) {
        AppUser user = getById(userId);        
        userDao.delete(user);
        return user.getUsername();
    }
    
    public AppUser getByUsername(String username){
        AppUser user = userDao.findByUsername(username);
        if (user == null) throw new UserNotFoundException();
        return user;
    }
}
