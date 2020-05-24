package com.oop.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author orestis
 */
@RestController
public class CartsController {
    
    @RequestMapping({"/user/cart"})
    public String map() {
        return "Here is a map for everyone";
    }
    
    // /add CartItem
    // /view CartItem
    // /edit CartItem
    // /delete CartItem
}
