package com.oop.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(HttpStatus.BAD_REQUEST)
public class SensorLocationNotFoundException extends RuntimeException {
    public SensorLocationNotFoundException(){
        super("SensorLocation not found...");
    }
}
