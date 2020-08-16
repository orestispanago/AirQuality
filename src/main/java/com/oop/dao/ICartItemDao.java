package com.oop.dao;

import com.oop.entities.CartItem;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICartItemDao extends CrudRepository<CartItem, Long> {
    List<CartItem> findByCartId(long cardIdId);
    //boolean existsByUserId(long userId);
}
