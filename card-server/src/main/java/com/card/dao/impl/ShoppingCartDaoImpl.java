package com.card.dao.impl;

import com.card.dao.ShoppingCartDao;
import com.card.model.Product;
import com.card.model.ShoppingCart;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Kazim Unalan
 */
@Repository
public class ShoppingCartDaoImpl implements ShoppingCartDao {

    private static List<Product> PRODUCT_LIST = new ArrayList<>();

    private static List<ShoppingCart> shoppingCartList = new ArrayList<>();
    private ShoppingCart shoppingCart = new ShoppingCart();

    @PostConstruct
    public void init() {
        shoppingCart.setName("My Cart");
    }

    @Override
    public ShoppingCart addToProductOnCart(String cartCode, Product product, Integer count) {
        if (shoppingCartList.stream().filter(shoppingCart -> shoppingCart.getCode().equals(cartCode)).count() == 0) {
            if (product != null) {
                shoppingCart.setCode(cartCode);
                PRODUCT_LIST.add(product);
                shoppingCart.setProductCodeList(PRODUCT_LIST);
            }
        } else {
            List<ShoppingCart> collect = shoppingCartList.stream().filter(shoppingCart -> shoppingCart.getCode().equals(cartCode)).collect(Collectors.toList());
            collect.get(0).setProductCodeList(PRODUCT_LIST);
        }
        return shoppingCart;
    }

    @Override
    public ShoppingCart findCart(String code) {
        List<ShoppingCart> collect = shoppingCartList.stream().filter(shoppingCart -> shoppingCart.getCode().equals(code)).collect(Collectors.toList());
        return collect.size() > 0 ? collect.get(0) : null;
    }

    @Override
    public Optional<ShoppingCart> editCart(String code) {
        return Optional.empty();
    }

    @Override
    public Optional<ShoppingCart> deleteCart(String code) {
        return Optional.empty();
    }

    @Override
    public List<ShoppingCart> findAllShoppingCarts() {
        return shoppingCartList;
    }
}
