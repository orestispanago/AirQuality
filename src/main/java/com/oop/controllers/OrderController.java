/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oop.controllers;

import com.oop.dao.UserDao;
import com.oop.entities.Order;
import com.oop.exceptions.UserNotFoundException;
import com.oop.models.OrderRequest;
import com.oop.services.IOrderService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author petros_trak
 */
@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    IOrderService orderservice;

    @Autowired
    UserDao userService;

    @GetMapping(value = "/{userId}/{orderId}", produces = "application/json")
    public Order readOrderByUserIdAndOrderId(@PathVariable long userId,@PathVariable long orderId) {
        if (userService.existsById(userId) == false) {
            throw new UserNotFoundException();
        }
        return orderservice.getById(orderId);
    }

    @GetMapping(value = "/{userId}", produces = "application/json")
    public List<Order> readAllOrdersByUserId(@PathVariable long userId) {
        if (userService.existsById(userId) == false) {
            throw new UserNotFoundException();
        }
        return orderservice.getAllByUserId(userId);
    }


    //  Create OrderRequest model that holds Cart  + Shipping Address
    // Cart and shipping address come from front
    
    @PostMapping(value = "/{userId}", produces = "application/json")
    public Order saveOrderByUserId(@RequestBody OrderRequest orderRequest,@PathVariable long userId) {
        if (userService.existsById(userId) == false) {
            throw new UserNotFoundException();
        }
        Order order =  orderservice.makeOrder(orderRequest);
        return orderservice.save(order);
    }
    // orderService:
    // List<CartItems> getCartItemsFromCart(Cart cart)
    // Order()
    
    // Make orderItems for each cartItem
        // Product getProductFromCartItem()
        // void orderItem.setProduct(Product product)
        // void orderItem.setQuantity(CartItem.getQuantity())   
        // Order.setOrderItem(orderItem)
    // order.setShippingAddress(orderRequest.getShippingAddress())
    // order.calcTotalPrice()
    
    // orderService.save(order)
    // sendMail(order)
    // emptyCart(cart)
}
