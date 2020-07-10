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
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@CrossOrigin
@RestController
@RequestMapping("/product-types")
public class ProductTypeController {

    @Autowired
    IProductTypeService productTypeService;

    @GetMapping
    public List<ProductType> all() {
        return productTypeService.getAll();
    }
    
    @GetMapping(value = "/{productTypeId}")
    public ProductType getProductTypeById(@PathVariable long productTypeId){
        return productTypeService.getById(productTypeId);
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public ProductType createProductType(@RequestBody ProductType productType) {
        return productTypeService.save(productType);
    }

    @PutMapping(value = "/{productTypeId}")
    public ProductType updateProductType(@PathVariable long productTypeId, @RequestBody ProductType productType) {
        return productTypeService.update(productTypeId, productType);
    }

    @DeleteMapping(value = "/{productTypeId}")
    @ResponseStatus(NO_CONTENT)
    public void deleteProductType(@PathVariable long productTypeId) {
        productTypeService.deleteById(productTypeId);
    }
}
