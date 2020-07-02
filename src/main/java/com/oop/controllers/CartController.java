package com.oop.controllers;

import com.oop.entities.Cart;
import com.oop.services.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.oop.dtos.CartDTO;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@CrossOrigin
@RestController
@RequestMapping("/carts")
public class CartController {

    @Autowired
    ICartService cartService;

    @RequestMapping(value = "/{username}", method = RequestMethod.GET, produces = "application/json")
    public Cart readCartByUsername(@PathVariable String username) {
        return cartService.getByUsername(username);
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public Cart createCartByUsername(@RequestBody(required = false) CartDTO cartDTO) {
        return cartService.save(cartDTO);
    }

    @PutMapping(value = "/{cartId}")
    public Cart updateCartByUsername(@PathVariable long cartId, @RequestBody CartDTO cartDTO) {
        return cartService.update(cartId, cartDTO);
    }

    @DeleteMapping(value = "/{cartId}")
    @ResponseStatus(NO_CONTENT)
    public void deleteCartByCartId(@PathVariable long cartId) {
        cartService.deleteById(cartId);
    }
}
