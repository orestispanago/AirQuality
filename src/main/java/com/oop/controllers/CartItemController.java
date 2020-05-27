//package com.oop.controllers;
//
//import com.oop.entities.CartItem;
//import com.oop.exceptions.CartNotFoundException;
//import com.oop.services.ICartService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
///**
// *
// * @author orestis
// */
//@RestController
//@RequestMapping("/carts/cartitems")
//public class CartItemController {
//
//    @Autowired
//    ICartItemService cartItemService;
//
//    @Autowired
//    ICartService cartService;
//
//    @RequestMapping(value = "/{cartId}/{productId}", method = RequestMethod.POST, produces = "application/json")
//    public CartItem create(@PathVariable long cartId, @PathVariable long productId, @RequestBody int quantity) {
//        CartItem cartItem = new CartItem();
//        if (cartService.existsById(cartId) == false) {
//            throw new CartNotFoundException();
//        }
//        return cartItemService.save(cartItem);
//    }
//}
