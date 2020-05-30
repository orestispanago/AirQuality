package com.oop.models;

import com.oop.entities.Cart;


public class OrderRequest {

    private Cart cart;
    private String shippingAddress;

    public OrderRequest() {
    }

    public OrderRequest(Cart cart, String shippingAddress) {
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

    @Override
    public String toString() {
        return "OrderRequest{" + "cart=" + cart + ", shippingAddress=" + shippingAddress + '}';
    }
    
    
}
