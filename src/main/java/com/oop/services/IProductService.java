/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oop.services;

import com.oop.entities.Product;
import java.util.List;

/**
 *
 * @author petros_trak
 */
public interface IProductService {
    Product getById(long productId);
    List<Product> getAllProducts();
    Product save(Product product);
}
