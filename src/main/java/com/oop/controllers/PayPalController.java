/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oop.controllers;

import com.oop.services.IPayPalService;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author petros_trak
 */
@RestController
@RequestMapping(value = "/paypal")
public class PayPalController {

    @Autowired
    IPayPalService payPalService;

    @PostMapping(value = "/make/payment")
    public Map<String, Object> makePayment(@RequestParam("sum") String sum) {
        return payPalService.createPayment(sum);
    }

    @PostMapping(value = "/complete/payment")
    public Map<String, Object> completePayment(HttpServletRequest request) {
        return payPalService.completePayment(request);
    }
}
