package com.oop.controllers;

import java.util.List;
import com.oop.entities.ProductType;
import com.oop.services.IProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/producttype")
public class ProductTypeController {

    @Autowired
    IProductTypeService productTypeService;

    @GetMapping
    public List<ProductType> all() {
        return productTypeService.getAll();
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public ProductType newProductType(@RequestBody ProductType productType) {
        productTypeService.save(productType);
        return productType;
    }

    @PutMapping
    public ProductType updateProductType(@RequestBody ProductType productType) {
        productTypeService.save(productType);
        return productType;
    }

    @DeleteMapping(value = "/{productTypeId}")
    @ResponseStatus(NO_CONTENT)
    public void deleteProductType(@PathVariable long productTypeId) {
        productTypeService.deleteById(productTypeId);
    }
}
