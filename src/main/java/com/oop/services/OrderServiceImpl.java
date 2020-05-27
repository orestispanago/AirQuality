/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oop.services;

import com.oop.dao.IOrderDao;
import com.oop.entities.Order;
import com.oop.exceptions.OrderNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author petros_trak
 */
@Service
public class OrderServiceImpl implements IOrderService{
    
    @Autowired
    IOrderDao orderDao;
    
    @Override
    public Order getByUserId(long id) {
        Order order = orderDao.findByUserId(id);
        if(order == null) throw new OrderNotFoundException();
        return order;
    }

    @Override
    public List<Order> getAllOrders() {
        Iterable<Order> orderEntities = orderDao.findAll();
        List<Order> orders = (List<Order>)orderEntities;
        return orders;
    }

    @Override
    public boolean existsById(long id) {
        return orderDao.existsByUserId(id);
    }

    @Override
    public boolean existsByUserId(long userId) {
        return orderDao.existsByUserId(userId);
    }

    @Override
    public Order save(Order order) {
        if(order != null)
            return orderDao.save(order);
        return null;
    }
    
    @Override
    public void deleteById(long id) {
        if (!orderDao.existsByUserId(id)) throw new OrderNotFoundException();
        orderDao.deleteById(id);
    }

    @Override
    public void delete(Order order) {
        if(!orderDao.existsById(order.getId())) throw new OrderNotFoundException();
        orderDao.delete(order);
    }

    @Override
    public Order update(Order order) {
        Order dbOrder = orderDao.findById(order.getId()).orElse(null);
        if(dbOrder == null) throw new OrderNotFoundException();
        return orderDao.save(order);
    }
    
}
