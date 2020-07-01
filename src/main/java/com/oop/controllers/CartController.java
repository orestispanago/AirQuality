package com.oop.controllers;

import com.oop.entities.AppUser;
import com.oop.entities.Cart;
import com.oop.entities.CartItem;
import com.oop.exceptions.CartAlreadyExistsException;
import com.oop.exceptions.UserNotFoundException;
import com.oop.services.ICartService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.oop.dao.IUserDao;
import com.oop.exceptions.CartNotFoundException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@CrossOrigin
@RestController
@RequestMapping("/carts")
public class CartController {

    @Autowired
    ICartService cartService;

    @Autowired
    IUserDao userService;

    @RequestMapping(value = "/{username}", method = RequestMethod.GET, produces = "application/json")
    public Cart readCartByUserId(@PathVariable String username) {
        if (!userService.existsByUsername(username)){
            throw new UserNotFoundException();
        }
        AppUser user = userService.findByUsername(username);
        return cartService.getByUserId(user.getId());
    }

    @PostMapping(value = "/{username}")
    public Cart updateCartByUsername(@PathVariable String username, @RequestBody(required = false) Cart cart) {
        // Get user id from username
        AppUser user = userService.findByUsername(username);
        long userId = user.getId();

        // If there is a cart in the request body, we need to update
//        if (cart != null) {
//            cart.setUser(user);
//            Cart updatedCart = cartService.update(cart);
//            return updatedCart;
//        } else { // else we need to create a cart for the user
//            if (cartService.existsByUserId(userId)) {
//                throw new CartAlreadyExistsException();
//            }
//            Cart newCart = new Cart();
//            newCart.setUser(user);
//            return cartService.save(newCart);
//        }
        //If a cart already exists for the user, update it
        if (cartService.existsByUserId(userId)) {
            System.out.println("**************UPDATING");
            cart.setUser(user);
            List<CartItem> cartItems = cart.getCartItems();
            for (CartItem cartItem : cartItems) {
                cartItem.setCart(cart);
            }
            cart.setCartItems(cartItems);
            Cart updatedCart = cartService.update(cart);
            return updatedCart;
        } // Else create a cart for the user and then update it
        else {
            // create
            Cart newCart = new Cart();
            newCart.setUser(user);
            Cart savedCart = cartService.save(newCart);
            // update
            List<CartItem> cartItems = cart.getCartItems();
            for (CartItem cartItem : cartItems) {
                cartItem.setCart(savedCart);
            }
            savedCart.setCartItems(cartItems);
            return cartService.update(savedCart);
        }
    }

    @PutMapping(value = "/{username}")
    public Cart updateCartByUserId(@PathVariable String username, @RequestBody Cart cart) {
        return cartService.update(cart);
//        if (!userService.existsByUsername(username)) throw new UserNotFoundException();
//        
//        if (!cartService.existsById(cart.getId())) throw new CartNotFoundException();
//        
//        List<CartItem> cartItems = cart.getCartItems();
//        for (CartItem cartItem : cartItems) {
//            cartItem.setCart(cart);
//        }
//        Cart updatedCart = cartService.update(cart);
//        return updatedCart;
    }
    
    @DeleteMapping(value = "/{cartId}")
    public void deleteCartByCartId(@PathVariable long cartId) {
        cartService.deleteById(cartId);
    }
}
