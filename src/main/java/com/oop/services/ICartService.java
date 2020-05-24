/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oop.services;

import com.oop.entities.Cart;
import java.util.List;

/**
 *
 * @author Walter
 */
public interface ICartService {
    Cart getByUserId(long id);
    List<Cart> getAllCarts();
    boolean existsById(long id);
    Cart save(Cart cart);
    void deleteById(long id);
    Cart updateCart(Cart cart);
}
