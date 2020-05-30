package com.oop.services;

import com.oop.entities.Cart;
import java.util.List;

public interface ICartService {
    Cart getByUserId(long id);
    List<Cart> getAllCarts();
    boolean existsById(long id);
    boolean existsByUserId(long userId);
    Cart save(Cart cart);
    void deleteById(long id);
    void delete(Cart cart);
    Cart update(Cart cart);
    Cart getById(long cartId);
}
