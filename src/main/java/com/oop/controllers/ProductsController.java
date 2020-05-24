package com.oop.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductsController {

    @RequestMapping(value = "/products", method = RequestMethod.GET, produces = "application/json")
    public String products() {
        return "List of all products";
    }
    
    @RequestMapping(value = "/products", method = RequestMethod.POST, produces = "application/json")
    public String newProduct() {
        return "Added new product";
    }
    
    @RequestMapping(value = "/products/{id}", method = RequestMethod.POST, produces = "application/json")
    public String updateProduct() {
        return "Updated product";
    }
    
    @RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public String deleteProduct() {
        return "Deleted product";
    }
    

    
    // /new
    // /edit
    // /delete
}
