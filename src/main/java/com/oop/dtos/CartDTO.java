package com.oop.dtos;

import com.oop.entities.Cart;

public class CartDTO {
    private String username;
    private Cart cart;

    public CartDTO() {
    }

    public CartDTO(String username, Cart cart) {
        this.username = username;
        this.cart = cart;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    @Override
    public String toString() {
        return "CartDTO{" + "username=" + username + ", cart=" + cart + '}';
    }
}
