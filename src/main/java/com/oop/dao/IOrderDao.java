package com.oop.dao;

import com.oop.entities.Order;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface IOrderDao extends CrudRepository<Order, Long>{
    Order findByUserId(long userId);
    List<Order> findAllByUserId(long userId);
    boolean existsByUserId(long userId);
}
