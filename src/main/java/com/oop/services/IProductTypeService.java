package com.oop.services;

import com.oop.entities.ProductType;
import java.util.List;

/**
 *
 * @author orestis
 */
public interface IProductTypeService {

    ProductType getById(long productTypeId);
    List<ProductType> getAll();
    ProductType save(ProductType productType);
    void deleteById(long productTypeId);
    ProductType update(long productTypeId, ProductType productType);
}
