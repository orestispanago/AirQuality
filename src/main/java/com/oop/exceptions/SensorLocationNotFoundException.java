package com.oop.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(HttpStatus.NOT_FOUND)
public class SensorLocationNotFoundException extends RuntimeException {
    public SensorLocationNotFoundException(){
        super("SensorLocation not found...");
    }
}
