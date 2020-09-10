/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oop.services.interfaces;

import com.oop.entities.AppUser;

/**
 *
 * @author Walter
 */
public interface IUserService {
    AppUser getById(long userId);
    AppUser getByUsername(String username);
}
