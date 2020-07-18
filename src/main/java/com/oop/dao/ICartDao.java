package com.oop.dao;

import com.oop.entities.Cart;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICartDao extends CrudRepository<Cart, Long> {
    Cart findByUserId(long userId);
    boolean existsByUserId(long userId);
}
