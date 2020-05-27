package com.oop.controllers;

import com.oop.entities.ProductType;
import com.oop.services.IProductTypeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author orestis
 */
@RestController
@RequestMapping("/producttype")
public class ProductTypeController {

    @Autowired
    IProductTypeService productTypeService;

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public List<ProductType> all() {
        return productTypeService.getAll();
    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public ProductType newProductType(@RequestBody ProductType productType) {
        productTypeService.save(productType);
        return productType;
    }

    @RequestMapping(method = RequestMethod.PUT, produces = "application/json")
    public ProductType updateProductType(@RequestBody ProductType productType) {
        productTypeService.save(productType);
        return productType;
    }

    @RequestMapping(value = "/{productTypeId}", method = RequestMethod.DELETE, produces = "application/json")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProductType(@PathVariable long productTypeId) {
        productTypeService.deleteById(productTypeId);
    }
}
