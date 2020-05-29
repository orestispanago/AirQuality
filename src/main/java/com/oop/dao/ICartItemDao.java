/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oop.dao;

import com.oop.entities.CartItem;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Walter
 */
@Repository
public interface ICartItemDao extends CrudRepository<CartItem, Long> {
    List<CartItem> findByCartId(long cardIdId);
    //boolean existsByUserId(long userId);
}
