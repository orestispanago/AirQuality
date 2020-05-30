package com.oop.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(HttpStatus.BAD_REQUEST)
public class SoldSensorNotFoundException extends RuntimeException {
    public SoldSensorNotFoundException(){
        super("SoldSensor not found...");
    }
}
