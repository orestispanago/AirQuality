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
    public Cart getByUserId(long userId) {
        Cart cart = cartDao.findByUserId(userId);
        if (cart == null) throw new CartNotFoundException(userId);
        return cart;
    }

    @Override
    public List<Cart> getAllCarts() {
        Iterable<Cart> cartEntities = cartDao.findAll();
        List<Cart> carts = (List<Cart>)cartEntities;
        return carts;
    }

    @Override
    public boolean existsById(long id) {
        Optional<Cart> cartEntity = cartDao.findById(id);
        if (cartEntity == null) return false;
        return true;
    }

    @Override
    public Cart save(Cart cart) {
        if (cart != null){
            Cart savedCart = cartDao.save(cart);
            return savedCart;
        }
        return null;
    }

    @Override
    public void deleteById(long id) {
       Optional<Cart> cartEntity = cartDao.findById(id);
       if (cartEntity == null) throw new CartNotFoundException(id);
       cartDao.deleteById(id);
    }

    @Override
    public Cart updateCart(Cart cart) {
       long cartId = cart.getId();
       Optional<Cart> cartEntity = cartDao.findById(cartId);
       if (cartEntity == null){
          throw new CartNotFoundException(cartId);
       }
       return cartDao.save(cart);
    }
    
}
