package com.oop.controllers;

import com.oop.entities.Product;
import com.oop.services.ProductServiceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductsController {

    @Autowired
    ProductServiceImpl productService;
    
    @GetMapping(produces = "application/json")
    public List<Product> products() {
       return productService.getAllProducts();
    }

    @PostMapping(produces = "application/json")
    public Product newProduct(@RequestBody Product product) {
        return productService.save(product);
    }

    @PutMapping(value = "/{productId}", produces = "application/json")
    public Product updateProduct(@PathVariable long productId) {
        Product product = productService.getById(productId);
        return productService.save(product);
    }

    @DeleteMapping(value = "/{productId}", produces = "application/json")
    public void deleteProductById(@PathVariable long productId) {
        productService.deleteById(productId);
    }

}
