package com.oop.services;

import com.oop.dao.IOrderDao;
import com.oop.entities.Cart;
import com.oop.entities.CartItem;
import com.oop.entities.Order;
import com.oop.entities.OrderItem;
import com.oop.entities.Product;
import com.oop.exceptions.CartNotFoundException;
import com.oop.exceptions.OrderNotFoundException;
import com.oop.exceptions.UserNotFoundException;
import com.oop.dtos.OrderDTO;
import com.oop.entities.AppUser;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements IOrderService {

    @Autowired
    IOrderDao orderDao;

    @Autowired
    IUserService userService;
    
    @Autowired
    ICartService cartService; 
    
    @Autowired
    IProductService productService;

    @Override
    public boolean existsById(long id) {
        return orderDao.existsByUserId(id);
    }

    @Override
    public boolean existsByUserId(long userId) {
        return orderDao.existsByUserId(userId);
    }

    @Override
    public Order save(OrderDTO orderDTO) {
        Order order = new Order();
        List<OrderItem> orderItems = getOrderItemsFromCartItems(orderDTO, order);
        order.setOrderItems(orderItems);
        order.setUser(userService.getByUsername(orderDTO.getUsername()));
        order.setTotalPrice(calcTotalPrice(order));
        order.setShippingAddress(orderDTO.getShippingAddress());
        return orderDao.save(order);
    }

    @Override
    public List<Order> getAllByUsername(String username) {
        AppUser user = userService.getByUsername(username);
        return orderDao.findAllByUserId(user.getId());
    }

    @Override
    public Order getById(long orderId) {
        return orderDao.findById(orderId).orElseThrow(()-> new OrderNotFoundException());
    }
    
//    @Override
//    public Order update(long orderId, OrderDTO orderDTO){
//        Order dbOrder = getById(orderId);
//        List<OrderItem> dbOrderItems = dbOrder.getOrderItems();
//        List<OrderItem> orderItems = getOrderItemsFromCartItems(orderDTO, dbOrder);
//       
//        for (OrderItem dbOrderItem : dbOrderItems){
//            for (int i = 0; i < orderItems.size(); i++){
//                OrderItem orderItem = orderItems.get(i);
//                if (orderItem.getProduct().getId() == dbOrderItem.getProduct().getId()){
//                    dbOrderItem.setPrice(orderItem.getPrice());
//                    dbOrderItem.setQuantity(orderItem.getQuantity());
//                }
//                else {
//                    dbOrderItems.add(orderItem);
//                }
//            }
//        }
//        
//        dbOrder.setShippingAddress(orderDTO.getShippingAddress());
//        dbOrder.setTotalPrice(calcTotalPrice(dbOrder));
//        return orderDao.save(dbOrder);
//    }
    
    @Override
    public void deleteById(long orderId){
        Order order = getById(orderId);
        orderDao.delete(order);
    }

    private OrderItem getOrderItemFromCartItem(CartItem cartItem, Order order) {
        OrderItem orderItem = new OrderItem();
        Product product = productService.getById(cartItem.getProduct().getId());
        orderItem.setProduct(product);
        orderItem.setPrice(product.getPrice());
        orderItem.setQuantity(cartItem.getQuantity());
        orderItem.setOrder(order);
        return orderItem;
    }
    
    private List<OrderItem> getOrderItemsFromCartItems(OrderDTO orderDTO, Order order){
        List<CartItem> cartItems = orderDTO.getCart().getCartItems();
        List<OrderItem> orderItems = new ArrayList();
        for (CartItem cartItem : cartItems) {
            orderItems.add(getOrderItemFromCartItem(cartItem, order));
        }
        return orderItems;
    }

    private double calcTotalPrice(Order order) {
        double totalPrice = 0;
        for (OrderItem orderItem : order.getOrderItems()) {
            totalPrice += (orderItem.getPrice() * orderItem.getQuantity());
        }
        return totalPrice;
    }
}
