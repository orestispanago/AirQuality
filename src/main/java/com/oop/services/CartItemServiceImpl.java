/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oop.services;

import com.oop.dao.ICartItemDao;
import com.oop.entities.CartItem;
import com.oop.exceptions.CartItemNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author petros_trak
 */
@Service
public class CartItemServiceImpl implements ICartItemService {

    @Autowired
    ICartItemDao cartItemDao;

    @Override
    public List<CartItem> getByCartId(long id) {
        return cartItemDao.findByCartId(id);

    }

    @Override
    public CartItem save(CartItem cartItem) {
        if (cartItem != null) {
            return cartItemDao.save(cartItem);
        }
        return null;
    }

    @Override
    public void deleteById(long id) {
        if (!cartItemDao.existsById(id)) {
            throw new CartItemNotFoundException();
        }
        cartItemDao.deleteById(id);
    }

    @Override
    public CartItem update(CartItem cartItem) {
        CartItem dbCartItem = cartItemDao.findById(cartItem.getId()).orElse(null);
        if (dbCartItem == null) {
            throw new CartItemNotFoundException();
        }
        return cartItemDao.save(dbCartItem);
    }

    @Override
    public CartItem getById(long id) {
        return cartItemDao.findById(id).orElse(null);
    }

}
