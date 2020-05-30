/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oop.services;

import com.oop.dao.IProductDao;
import com.oop.entities.Product;
import com.oop.exceptions.ProductNotFoundException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author petros_trak
 */
@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    IProductDao productDao;

    @Override
    public Product getById(long productId) {
        return productDao.findById(productId).orElseThrow(ProductNotFoundException::new);
    }

    @Override
    public List<Product> getAllProducts() {
        Iterable<Product> productEntity = productDao.findAll();
        List<Product> products = (List<Product>) productEntity;
        return products;
    }

    @Override
    public Product save(Product product) {
        if (product == null) {
            return null;
        }
        return productDao.save(product);
    }

}
