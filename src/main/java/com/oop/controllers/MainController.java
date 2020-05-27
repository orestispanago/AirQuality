package com.oop.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @RequestMapping({"/"})
    public String landingPage() {
        return "This is the landing page";
    }

    @RequestMapping({"/map"})
    public String map() {
        return "Here is a map for everyone";
    }

}
