package com.oop.controllers;

import com.oop.entities.Product;
import com.oop.services.ProductServiceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/products")
public class ProductsController {

    @Autowired
    ProductServiceImpl productService;

    @GetMapping
    public List<Product> products() {
        return productService.getAllProducts();
    }
    
    @GetMapping(value = "/{productId}")
    public Product getProduct(@PathVariable long productId) {
        return productService.getById(productId);
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public Product newProduct(@RequestBody Product product) {
        return productService.save(product);
    }

    @PutMapping(value = "/{productId}")
    public Product updateProduct(@PathVariable long productId, @RequestBody Product product) {
        return productService.update(productId, product);
    }

    @DeleteMapping(value = "/{productId}")
    @ResponseStatus(NO_CONTENT)
    public void deleteProduct(@PathVariable long productId) {
        productService.deleteById(productId);
    }
}
