package com.oop.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author orestis
 */
@RestController
public class ProductsController {

    @RequestMapping({"/products"})
    public String products() {
        return "Products, shop or whateva";
    }
    
    // /new
    // /edit
    // /delete
}
