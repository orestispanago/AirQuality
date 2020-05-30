/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oop.services;

import com.oop.dao.IOrderDao;
import com.oop.dao.UserDao;
import com.oop.entities.Cart;
import com.oop.entities.CartItem;
import com.oop.entities.Order;
import com.oop.entities.OrderItem;
import com.oop.entities.Product;
import com.oop.exceptions.CartItemNotFoundException;
import com.oop.exceptions.CartNotFoundException;
import com.oop.exceptions.OrderNotFoundException;
import com.oop.exceptions.UserNotFoundException;
import com.oop.models.OrderRequest;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author petros_trak
 */
@Service
public class OrderServiceImpl implements IOrderService {

    @Autowired
    IOrderDao orderDao;

    @Autowired
    UserDao userDao;

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
        if (order != null) {
            return orderDao.save(order);
        }
        return null;
    }

    @Override
    public List<Order> getAllByUserId(long userId) {
        if (!userDao.existsById(userId)) {
            throw new UserNotFoundException();
        }
        return orderDao.findAllByUserId(userId);
    }

    @Override
    public Order getById(long orderId) {
        return orderDao.findById(orderId).orElseThrow(OrderNotFoundException::new);
    }

    @Override
    public Order makeOrder(OrderRequest orderRequest) throws CartNotFoundException {
        Cart cart = orderRequest.getCart();
        Order order = new Order();
        List<OrderItem> orderItems = new ArrayList();
        for (CartItem cartItem : cart.getCartItems()) {
            orderItems.add(makeOrderItem(cartItem));
        }
            System.out.println(orderItems);
        order.setUser(cart.getUser());
        order.setOrderItems(orderItems);
        order.setTotalPrice(calcTotalPrice(order));
        order.setShippingAddress(orderRequest.getShippingAddress());
        return order;
    }

    private OrderItem makeOrderItem(CartItem cartItem) throws CartItemNotFoundException {
        OrderItem orderItem = new OrderItem();
        Product product = cartItem.getProduct();
//        orderItem.setProduct(product);
        orderItem.setPrice(product.getPrice());
        orderItem.setQuantity(cartItem.getQuantity());
        return orderItem;
    }

    private double calcTotalPrice(Order order) {
        double totalPrice = 0;
        for (OrderItem orderItem : order.getOrderItems()) {
            totalPrice += (orderItem.getPrice() * orderItem.getQuantity());
        }
        return totalPrice;
    }

}
