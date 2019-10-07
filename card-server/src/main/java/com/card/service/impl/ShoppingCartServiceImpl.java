package com.card.service.impl;

import com.card.dao.ShoppingCartDao;
import com.card.model.Product;
import com.card.model.ShoppingCart;
import com.card.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Kazim Unalan
 */
@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    //    @Qualifier("shoppingCartDao")
    @Autowired
    private ShoppingCartDao shoppingCartDao;

    @Override
    public ShoppingCart addProductShoppingCart(String cartCode, Product product, Integer count) {
        return shoppingCartDao.addToProductOnCart(cartCode, product, count);
    }

    @Override
    public ShoppingCart getShoppingCart(String code) {
        return shoppingCartDao.findCart(code);
    }

    @Override
    public Optional<ShoppingCart> editShoppingCart(String code) {
        return Optional.empty();
    }

    @Override
    public Optional<ShoppingCart> deleteShoppingCart(String code) {
        return Optional.empty();
    }

    @Override
    public List<ShoppingCart> getAllShoppingCarts() {
        return null;
    }
}
