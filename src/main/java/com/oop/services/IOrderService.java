package com.oop.services;

import com.oop.entities.Order;
import com.oop.dtos.OrderDTO;
import java.util.List;

public interface IOrderService {
    Order getById(long orderId);
    List<Order> getAllByUsername(String username);
    boolean existsById(long id);
    boolean existsByUserId(long userId);
    Order save(OrderDTO orderDTO);
//    Order update(long orderId, OrderDTO orderDTO);
    void deleteById(long orderId);
}
