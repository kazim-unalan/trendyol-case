package com.card.service;

import com.card.model.Product;
import com.card.model.ShoppingCart;

import java.util.List;
import java.util.Optional;

/**
 * @author Kazim Unalan
 */
public interface ShoppingCartService {

    ShoppingCart addProductShoppingCart(String cartCode, Product product, Integer count);

    ShoppingCart getShoppingCart(String code);

    Optional<ShoppingCart> editShoppingCart(String code);

    Optional<ShoppingCart> deleteShoppingCart(String code);

    List<ShoppingCart> getAllShoppingCarts();

}
