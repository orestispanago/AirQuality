package com.oop.controllers;

import com.oop.dao.UserDao;
import com.oop.entities.CartItem;
import com.oop.exceptions.CartItemNotFoundException;
import com.oop.exceptions.CartNotFoundException;
import com.oop.exceptions.UserNotFoundException;
import com.oop.services.ICartItemService;
import com.oop.services.ICartService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author orestis
 */
@RestController
@RequestMapping("/carts/items")
public class CartItemController {

    @Autowired
    ICartItemService cartItemService;

    @Autowired
    ICartService cartService;
    
    @Autowired
    UserDao userService;
    
    @RequestMapping(value = "/{cardId}", method = RequestMethod.GET, produces = "application/json")
    public List<CartItem> readByCartId(@PathVariable long cardId){
        if(userService.existsById(cardId) == false) throw new UserNotFoundException();
        return cartItemService.getByCartId(cardId);
    }
    
    @RequestMapping(value = "/{cartId}/{productId}/{quantity}", method = RequestMethod.POST, produces = "application/json")
    public CartItem createCartItem(@PathVariable long cartId, @PathVariable long productId, @PathVariable int quantity) {
        CartItem cartItem = new CartItem();
        if (cartService.existsById(cartId) == false) {
            throw new CartNotFoundException();
        }
        return cartItemService.save(cartItem);
    }
    
//    @RequestMapping(value = "/{userId}", method = RequestMethod.PUT, produces = "application/json")
//    public CartItem updateCartItemByUserId(@PathVariable long userId, @RequestBody CartItem cartItem){
//        if(userService.existsById(userId) == false) throw new UserNotFoundException();
//        long cartItemId = cartItem.getId();
//        if(cartItemService.existsById(cartItemId) == false) throw new CartItemNotFoundException();
//        CartItem updateCartItem = cartItemService.update(cartItem);
//        return updateCartItem;
//    }
    
    
    @RequestMapping(value = "/{cartItemId}", method = RequestMethod.DELETE)
    public void deleteCartItemById(@PathVariable long cartItemId){
        cartItemService.deleteById(cartItemId);
    }
}//create save update @requestbody cart cart
