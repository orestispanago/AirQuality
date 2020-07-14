package com.oop.services.interfaces;

import com.oop.dtos.CartDTO;
import com.oop.entities.Cart;
import java.util.List;

public interface ICartService {
    Cart getByUserId(long id);
    Cart getByUsername(String username);
    List<Cart> getAllCarts();
    boolean existsById(long id);
    boolean existsByUserId(long userId);
    Cart save(CartDTO cartDTO);
    void deleteById(long id);
    void delete(Cart cart);
    Cart update(long cartId, CartDTO cartDTO);
    Cart getById(long cartId);
}
