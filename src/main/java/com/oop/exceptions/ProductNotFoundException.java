/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oop.exceptions;

/**
 *
 * @author petros_trak
 */
public class ProductNotFoundException extends RuntimeException{
    public ProductNotFoundException(){
        super("Product has not been found..");
    }
}
