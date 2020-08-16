package com.oop.controllers;

import com.oop.entities.AppUser;
import com.oop.services.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.http.HttpStatus.NO_CONTENT;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    
    @Autowired
    IUserService userService;
    
    @GetMapping(value = "/{id}")
    public AppUser readUserById(@PathVariable long id) {
        return userService.getById(id);
    }
    
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(NO_CONTENT)
    public void deleteByUserId(@PathVariable long id) {
        userService.deleteById(id);
    }
}
