package com.oop.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author orestis
 */
@Entity
@Table(name = "order_items")

public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "products_id", referencedColumnName = "id")
    private Product product;
    
    @ManyToOne
    @JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
    private Order order;
    
    private int quantity;

    private double price;

    private String writeApiKey;

    public OrderItem() {
    }

    public OrderItem(Product product, Order order, int quantity, double price, String writeApiKey) {
//        this.product = product;
        this.order = order;
        this.quantity = quantity;
        this.price = price;
        this.writeApiKey = writeApiKey;
    }

    public long getId() {
        return id;
    }

//    public Product getProduct() {
//        return product;
//    }
//
//    public void setProduct(Product product) {
//        this.product = product;
//    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getWriteApiKey() {
        return writeApiKey;
    }

    public void setWriteApiKey(String writeApiKey) {
        this.writeApiKey = writeApiKey;
    }

    @Override
    public String toString() {
        return "OrderItem{" + "id=" + id + ", product=" + product + ", order=" + order + ", quantity=" + quantity + ", price=" + price + ", writeApiKey=" + writeApiKey + '}';
    }

}
