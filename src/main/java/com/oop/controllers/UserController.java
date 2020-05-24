package com.oop.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author orestis
 */

@RestController
public class UserController {
    @RequestMapping({"/user/sensors"})
    public String sensors(){
        return "A list of a user's sensors";
    }
    // /user/sensor/data
    // /user/sensor/register
    // /user/sensor/delete
}
