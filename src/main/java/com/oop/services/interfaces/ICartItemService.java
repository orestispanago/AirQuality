/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oop.services.interfaces;

import com.oop.entities.CartItem;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author petros_trak
 */
@Service
public interface ICartItemService {
    List<CartItem> getByCartId(long id);
    //List<CartItem> getAllCartItems();
    //boolean existsById(long id);
    //boolean existsByUserId( long userId);
    CartItem save(CartItem cartItem);
    void deleteById(long id);
    //void delete(CartItem cartItem);
    CartItem update(CartItem cartItem);
    CartItem getById(long id);
}
