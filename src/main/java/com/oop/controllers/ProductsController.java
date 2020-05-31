package com.oop.controllers;

import com.oop.entities.Product;
import com.oop.services.ProductServiceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductsController {

    @Autowired
    ProductServiceImpl productService;

    @GetMapping(value = "/products",produces = "application/json")
    public List<Product> products() {
        return productService.getAllProducts();
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
