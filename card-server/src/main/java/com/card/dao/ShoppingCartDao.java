package com.card.dao;

import com.card.model.Product;
import com.card.model.ShoppingCart;

import java.util.List;
import java.util.Optional;

/**
 * @author Kazim Unalan
 */
public interface ShoppingCartDao {

    ShoppingCart addToProductOnCart(String cartCode, Product product, Integer count);

    ShoppingCart findCart(String code);

    Optional<ShoppingCart> editCart(String code);

    Optional<ShoppingCart> deleteCart(String code);

    List<ShoppingCart> findAllShoppingCarts();


}
