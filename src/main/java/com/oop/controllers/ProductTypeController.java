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
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

/**
 *
 * @author orestis
 */
@RestController
@RequestMapping("/producttype")
public class ProductTypeController {

    @Autowired
    IProductTypeService productTypeService;

    @RequestMapping(method = GET, produces = "application/json")
    public List<ProductType> all() {
        return productTypeService.getAll();
    }

    @RequestMapping(method = POST, produces = "application/json")
    @ResponseStatus(CREATED)
    public ProductType newProductType(@RequestBody ProductType productType) {
        productTypeService.save(productType);
        return productType;
    }

    @RequestMapping(method = PUT, produces = "application/json")
    public ProductType updateProductType(@RequestBody ProductType productType) {
        productTypeService.save(productType);
        return productType;
    }

    @RequestMapping(value = "/{productTypeId}", method = DELETE, produces = "application/json")
    @ResponseStatus(NO_CONTENT)
    public void deleteProductType(@PathVariable long productTypeId) {
        productTypeService.deleteById(productTypeId);
    }
}
