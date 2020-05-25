/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oop.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author Walter
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CartNotFoundException extends RuntimeException {
    public CartNotFoundException(){
        super("The cart for the specified user id does not exist");
    }
}
