package com.oop.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProductTypeNotFoundException extends RuntimeException {
    public ProductTypeNotFoundException(){
        super("The product for the specified id does not exist");
    }
}
