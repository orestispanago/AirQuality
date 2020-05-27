package com.oop.services;

import com.oop.dao.IProductTypeDao;
import com.oop.entities.ProductType;
import com.oop.exceptions.ProductTypeNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author orestis
 */
@Service
public class ProductTypeServiceImpl implements IProductTypeService {

    @Autowired
    IProductTypeDao productTypeDao;

    @Override
    public ProductType getById(long productTypeId) {
        return productTypeDao.findById(productTypeId).orElseThrow(ProductTypeNotFoundException::new);
    }

    @Override
    public List<ProductType> getAll() {
        return (List<ProductType>) productTypeDao.findAll();
    }

    @Override
    public ProductType save(ProductType productType) {
        if (productType != null){
            return productTypeDao.save(productType);
        }
        return null;    }

    @Override
    public void deleteById(long productTypeId) {
        if(!productTypeDao.existsById(productTypeId)) throw new ProductTypeNotFoundException();
        productTypeDao.deleteById(productTypeId);
    }

}
