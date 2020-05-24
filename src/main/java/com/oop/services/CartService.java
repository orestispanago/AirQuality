/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oop.services;

import com.oop.dao.ICartDao;
import com.oop.entities.Cart;
import com.oop.exceptions.CartNotFoundException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Walter
 */
@Service
public class CartService implements ICartService {
    @Autowired
    ICartDao cartDao;
    
    @Override
    public Cart getCartByUserId(long userId) {
        Optional<Cart> cartEntity = cartDao.findById(userId);
        if (cartEntity == null) throw new CartNotFoundException(userId);
        return cartEntity.get();
    }

    @Override
    public List<Cart> getAllCarts() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean existsById(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Cart save(Cart cart) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteById(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Cart updateCartById(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
