package com.oop.dtos;

import com.oop.entities.Cart;

public class OrderDTO {
    private Cart cart;
    private String shippingAddress;
    private String username;

    public OrderDTO() {
    }

    public OrderDTO(Cart cart, String shippingAddress) {
        this.cart = cart;
        this.shippingAddress = shippingAddress;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "OrderDTO{" + "cart=" + cart + ", shippingAddress=" + shippingAddress + ", username=" + username + '}';
    }
}
