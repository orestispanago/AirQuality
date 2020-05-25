package com.oop.controllers;

import com.oop.dao.IProductDao;
import com.oop.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductsController {

    @RequestMapping(value = "/products", method = RequestMethod.GET, produces = "application/json")
    public String products() {
        return "List of all products";
    }

    @Autowired
    IProductDao prodService;

    @RequestMapping(value = "/products", method = RequestMethod.POST, produces = "application/json")
    public Product newProduct(@RequestBody Product prod) {
        prodService.save(prod);
        return prod;
    }

    @RequestMapping(value = "/products/{id}", method = RequestMethod.POST, produces = "application/json")
    public String updateProduct() {
        return "Updated product";
    }

    @RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public String deleteProduct() {
        return "Deleted product";
    }

}
