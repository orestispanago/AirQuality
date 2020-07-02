package com.oop.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cart_items")
public class CartItem {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    private int quantity;
    
    @ManyToOne
    @JsonIgnore
    private Cart cart;
    
    @ManyToOne
    @JoinColumn(name = "products_id")
    private Product product;
    
    public CartItem() {};

    public CartItem(int quantity) {
        this.quantity = quantity;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 71 * hash + this.quantity;
        hash = 71 * hash + Objects.hashCode(this.cart);
        hash = 71 * hash + Objects.hashCode(this.product);
        return hash;
    }

//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj) {
//            return true;
//        }
//        if (obj == null) {
//            return false;
//        }
//        if (getClass() != obj.getClass()) {
//            return false;
//        }
//        final CartItem other = (CartItem) obj;
//        if (this.id != other.id) {
//            return false;
//        }
//        if (this.quantity != other.quantity) {
//            return false;
//        }
//        if (!Objects.equals(this.cart, other.cart)) {
//            return false;
//        }
//        if (!Objects.equals(this.product, other.product)) {
//            return false;
//        }
//        return true;
//    }

    @Override
    public String toString() {
        return "CartItem{" + "id=" + id + ", quantity=" + quantity + ", cart=" + cart + ", product=" + product + '}';
    }
}
