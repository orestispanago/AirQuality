package com.oop.services;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;

public interface IPayPalService {
    Map<String, Object> createPayment(String sum);
    Map<String, Object> completePayment(HttpServletRequest req);
}