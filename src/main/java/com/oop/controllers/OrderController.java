package com.oop.controllers;

import com.oop.entities.Order;
import com.oop.dtos.OrderDTO;
import com.oop.services.interfaces.IOrderService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@CrossOrigin
@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    IOrderService orderService;

    @GetMapping
    public List<Order> readAllOrders() {
        return orderService.getAllOrders();
    }
    
    @GetMapping(value = "/{orderId}")
    public Order readOrderByOrderId(@PathVariable long orderId) {
        return orderService.getById(orderId);
    }

    @GetMapping(value = "/users/{username}")
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
    @ResponseStatus(NO_CONTENT)
    public void deleteOrder(@PathVariable long orderId){
        orderService.deleteById(orderId);
    }
}
