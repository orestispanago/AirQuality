package com.oop.controllers;

import com.oop.entities.AppUser;
import com.oop.services.ICartService;
import com.oop.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
    public void deleteByUserId(@PathVariable long id) {
        userService.deleteById(id);
    }
}
