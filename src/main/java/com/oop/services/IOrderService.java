/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oop.services;

import com.oop.entities.Order;
import com.oop.models.OrderRequest;
import java.util.List;

/**
 *
 * @author petros_trak
 */
public interface IOrderService {
    Order getById(long orderId);
    List<Order> getAllByUserId(long userId);
    boolean existsById(long id);
    boolean existsByUserId(long userId);
    Order save(Order order);
    Order makeOrder(OrderRequest orderRequest);
    
}
