package com.card.client.product;

import com.card.model.Product;
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
            value = "code"
    )
    @ResponseStatus(value = HttpStatus.OK)
    ResponseEntity<?> addProductShoppingCart(@RequestParam(value = "code") String code, @RequestParam(value = "code") Integer count);

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/product/code"
    )
    @ResponseStatus(value = HttpStatus.OK)
    Product getProduct(@RequestParam(value = "code") String code);
}
