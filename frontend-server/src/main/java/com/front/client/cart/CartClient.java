package com.front.client.cart;

import com.front.model.ShoppingCart;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * @author Kazim Unalan
 */
@FeignClient("cart-server")
public interface CartClient {

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/shopping-cart/code"
    )
    @ResponseStatus(value = HttpStatus.OK)
    ShoppingCart addProductShoppingCart(@RequestParam(value = "cartCode") String cartCode, @RequestParam(value = "code") String code, @RequestParam(value = "count") Integer count);
}
