package com.oop.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(HttpStatus.BAD_REQUEST)
public class SoldSensorIdDoesNotExistException extends RuntimeException {
    public SoldSensorIdDoesNotExistException(long id){
        super("sensorLocation with  id '" + id + "' does not exist.");
    }
}
