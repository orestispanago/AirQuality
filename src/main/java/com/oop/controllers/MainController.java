package com.oop.controllers;

import com.oop.entities.CartItem;
import javax.servlet.http.Cookie;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

//    @RequestMapping({"/"})
//    public String landingPage() {
//
//        return "This is the landing page";
//    }
    @RequestMapping({"/map"})
    public String map() {
        return "Here is a map for everyone";
    }

//    @GetMapping("/")
//    public String readCookie(@CookieValue(value = "username", defaultValue = "Atta") String username) {
//        CartItem cartItem = new CartItem(1);
//        return "Hey! My username is " + username;
//
//    }

}
