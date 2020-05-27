/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oop.controllers;

import com.oop.dao.UserDao;
import com.oop.entities.Order;
import com.oop.exceptions.UserNotFoundException;
import com.oop.services.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author petros_trak
 */
@RestController
@RequestMapping("/orders")
public class OrderController {
    
    @Autowired
    IOrderService orderservice;
    
    @Autowired
    UserDao userService;
    
    @RequestMapping(value = "/{userId}", method = RequestMethod.GET, produces = "application/json")
    public Order readOrderByUserId(@PathVariable long userId){
        if(userService.existsById(userId) == false) throw new UserNotFoundException();
        return orderservice.getByUserId(userId);
    }
    
}
