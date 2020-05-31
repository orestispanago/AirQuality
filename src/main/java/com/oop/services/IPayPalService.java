/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oop.services;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author petros_trak
 */
public interface IPayPalService {
    Map<String, Object> createPayment(String sum);
    Map<String, Object> completePayment(HttpServletRequest req);
}