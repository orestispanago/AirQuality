package com.oop.services;

import com.oop.services.interfaces.IUserService;
import com.oop.services.interfaces.ICartService;
import com.oop.dao.ICartDao;
import com.oop.dtos.CartDTO;
import com.oop.entities.AppUser;
import com.oop.entities.Cart;
import com.oop.entities.CartItem;
import com.oop.exceptions.CartAlreadyExistsException;
import com.oop.exceptions.CartNotFoundException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements ICartService {

    @Autowired
    ICartDao cartDao;

    @Autowired
    IUserService userService;

    @Override
    public Cart getByUserId(long userId) {
        Cart cart = cartDao.findByUserId(userId);
        if (cart == null) {
            throw new CartNotFoundException();
        }
        return cart;
    }
    
    @Override
    public Cart getByUsername(String username) {
        AppUser user = userService.getByUsername(username);
        Cart cart = cartDao.findByUserId(user.getId());
        return cart;
    }

    @Override
    public boolean existsByUserId(long userId) {
        return cartDao.existsByUserId(userId);
    }

    @Override
    public List<Cart> getAllCarts() {
        Iterable<Cart> cartEntities = cartDao.findAll();
        List<Cart> carts = (List<Cart>) cartEntities;
        return carts;
    }

    @Override
    public boolean existsById(long id) {
        Optional<Cart> cartEntity = cartDao.findById(id);
        if (cartEntity == null) {
            return false;
        }
        return true;
    }

    @Override
    public Cart save(CartDTO cartDTO) {
        AppUser user = userService.getByUsername(cartDTO.getUsername());
        if (cartDao.existsByUserId(user.getId())) throw new CartAlreadyExistsException();
        Cart newCart = new Cart();
        newCart.setUser(user);
        List<CartItem> cartItems = cartDTO.getCart().getCartItems();
        for (CartItem cartItem : cartItems) {
            cartItem.setCart(newCart);
        }
        newCart.setCartItems(cartItems);
        return cartDao.save(newCart);
    }

    @Override
    public Cart update(long cartId, CartDTO cartDTO) {
        Cart cart = cartDTO.getCart();
        Cart dbCart = getById(cartId);
        AppUser user = dbCart.getUser();
        
        cart.setUser(user);
        List<CartItem> cartItems = cart.getCartItems();
        for (CartItem cartItem : cartItems) {
            cartItem.setCart(cart);
        }
        cart.setCartItems(cartItems);
        cart.setId(dbCart.getId());
        return cartDao.save(cart);
    }

    @Override
    public void delete(Cart cart) {
        Cart dbCart = getById(cart.getId());
        cartDao.delete(dbCart);
    }

    @Override
    public void deleteById(long cartId) {
        Cart dbCart = getById(cartId);
        dbCart.getCartItems().clear();
        dbCart.getUser().setCart(null);
        dbCart.setUser(null);
        cartDao.delete(dbCart);
    }

    @Override
    public Cart getById(long cartId) {
        return cartDao.findById(cartId).orElseThrow(()-> new CartNotFoundException());
    }

//    @Override
//    public Cart save(Cart cart) {
//        AppUser user = userService.getByUsername(cart.getUser().getUsername());
//        if (cartDao.existsByUserId(user.getId())) throw new CartAlreadyExistsException();
//        Cart newCart = new Cart();
//        newCart.setUser(user);
//        List<CartItem> cartItems = cart.getCartItems();
//        for (CartItem cartItem : cartItems) {
//            cartItem.setCart(newCart);
//        }
//        newCart.setCartItems(cartItems);
//        return cartDao.save(newCart);
//    }
}
