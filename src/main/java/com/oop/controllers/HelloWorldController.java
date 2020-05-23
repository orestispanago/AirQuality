package com.oop.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@RequestMapping({ "/" })
	public String landingPage() {
		return "This is the landing page";
	}
	@RequestMapping({ "/products" })
	public String login() {
		return "Products, shop or whateva";
	}
	@RequestMapping({ "/map" })
	public String map() {
		return "Here is a map for everyone";
	}
	@RequestMapping({ "/hello" })
	public String firstPage() {
		return "Hello World";
	}

}