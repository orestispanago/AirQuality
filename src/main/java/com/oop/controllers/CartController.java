package com.oop.controllers;

import com.oop.dao.UserDao;
import com.oop.entities.Cart;
import com.oop.errors.UserNotFoundException;
import com.oop.exceptions.CartNotFoundException;
import com.oop.services.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/carts")
public class CartController {
    
    @Autowired
    ICartService cartService; 
    
    @Autowired
    UserDao userService;
    
    @RequestMapping(value = "/{userId}", method = RequestMethod.GET, produces = "application/json")
    public Cart readCartByUserId(@PathVariable long userId) {
        if (userService.existsById(userId) == false) throw new UserNotFoundException();
        return cartService.getByUserId(userId);
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.POST, produces = "application/json")
    public Cart createCartByUserId(@PathVariable long userId) {
        if (userService.existsById(userId) == false) throw new UserNotFoundException();
        Cart cart = new Cart();
        cart.setUserId(userId);
        return cartService.save(cart);
    }
    
    @RequestMapping(value = "/{userId}", method = RequestMethod.PUT, produces = "application/json")
    public Cart updateCart(@PathVariable long userId, @RequestBody Cart cart) {
        if (userService.existsById(userId) == false) throw new UserNotFoundException();
        long cartId = cart.getId();
        if (cartService.existsById(cartId) == false) throw new CartNotFoundException();
        Cart updatedCart = cartService.update(cart);
        return updatedCart;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public String deleteCartByCartId(@PathVariable long id) {
        cartService.deleteById(id);
        return "tCart deleted";
    }
    
    @RequestMapping(method = RequestMethod.DELETE, produces = "application/json")
    public String deleteCart(@RequestBody Cart cart) {
        cartService.delete(cart);
        return "tCart deleted";
    }
    
  
}
