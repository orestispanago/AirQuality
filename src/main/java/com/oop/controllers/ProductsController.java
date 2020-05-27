package com.oop.controllers;

import com.oop.entities.Product;
import com.oop.services.ProductServiceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductsController {

    @Autowired
    ProductServiceImpl productService;
    
    @RequestMapping(value = "/products", method = RequestMethod.GET, produces = "application/json")
    public String products() {
        List<Product> products = productService.getAllProducts();
        return "List of all products";
    }

    @RequestMapping(value = "/products", method = RequestMethod.POST, produces = "application/json")
    public Product newProduct(@RequestBody Product product) {
        return productService.save(product);
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
