package com.oop.controllers;

import com.oop.entities.Order;
import com.oop.exceptions.UserNotFoundException;
import com.oop.dtos.OrderDTO;
import com.oop.services.IOrderService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.oop.dao.IUserDao;
import static org.springframework.http.HttpStatus.CREATED;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    IOrderService orderService;

    @GetMapping(value = "/{orderId}")
    public Order readOrderByOrderId(@PathVariable long orderId) {
        return orderService.getById(orderId);
    }

    @GetMapping(value = "/{username}")
    public List<Order> readAllOrdersByUsername(@PathVariable String username) {
        return orderService.getAllByUsername(username);
    }
    
    @PostMapping
    @ResponseStatus(CREATED)
    public Order saveOrder(@RequestBody OrderDTO orderDTO) {
        return orderService.save(orderDTO);
    }
    
//    @PutMapping(value = "/{orderId}")
//    public Order updateOrder(@PathVariable long orderId, @RequestBody OrderDTO orderDTO) {
//        return orderService.update(orderId, orderDTO);
//    }
    
    @DeleteMapping(value = "/{orderId}")
    public void deleteOrder(@PathVariable long orderId){
        orderService.deleteById(orderId);
    }
}
