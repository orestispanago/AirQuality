/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oop.services;

import com.oop.entities.Order;
import java.util.List;

/**
 *
 * @author petros_trak
 */
public interface IOrderService {
    public Order getByUserId(long id);
    public List<Order> getAllOrders();
    public boolean existsById(long id);
    public boolean existsByUserId(long userId);
    public Order save(Order order);
    public void deleteById(long id);
    public void delete(Order order);
    public Order update(Order order);
}
