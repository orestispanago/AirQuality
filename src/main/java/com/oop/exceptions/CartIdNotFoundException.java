package com.oop.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CartIdNotFoundException extends RuntimeException {
    public CartIdNotFoundException(){
        super("The cart with the specified cartId does not exist");
    }
}
