package com.front.client.product;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/**
 * @author Kazim Unalan
 */
@FeignClient("product-server")
public interface ProductClient {

    @RequestMapping(
            method = RequestMethod.GET,
            value = "shopping-cart/code"
    )
    @ResponseStatus(value = HttpStatus.OK)
    ResponseEntity<?> addProductShoppingCart(@RequestParam(value = "code") String code);

}
