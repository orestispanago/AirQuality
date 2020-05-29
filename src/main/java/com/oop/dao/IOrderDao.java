/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oop.dao;

import com.oop.entities.Order;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author petros_trak
 */
public interface IOrderDao extends CrudRepository<Order, Long>{
    Order findByUserId(long userId);
    List<Order> findAllByUserId(long userId);
    boolean existsByUserId(long userId);
}
