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

    @RequestMapping(value = "/{username}", method = RequestMethod.POST, produces = "application/json")
    public Cart updateCartByUserId(@PathVariable String username, @RequestBody(required = false) Cart cart) {
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
            if (cartService.existsByUserId(userId)) {
                throw new CartAlreadyExistsException();
            }
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

//    @RequestMapping(value = "/{userId}", method = RequestMethod.PUT, produces = "application/json")
//    public Cart updateCartByUserId(@PathVariable long userId, @RequestBody Cart cart) {
//        if (userService.existsById(userId) == false) {
//            throw new UserNotFoundException();
//        }
//        long cartId = cart.getId();
//        if (cartService.existsById(cartId) == false) {
//            throw new CartNotFoundException();
//        }
//        List<CartItem> cartItems = cart.getCartItems();
//        for (CartItem cartItem : cartItems) {
//            cartItem.setCart(cart);
//        }
//        Cart updatedCart = cartService.update(cart);
//        return updatedCart;
//    }
//    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "application/json")
//    public String deleteCartByCartId(@PathVariable long id) {
//        cartService.deleteById(id);
//        return "{\"outcome\": \"cart deleted\"}";
//    }
//    
//    @RequestMapping(method = RequestMethod.DELETE, produces = "application/json")
//    public String deleteCart(@RequestBody Cart cart) {
//        cartService.delete(cart);
//        return "tCart deleted";
//    }
}
