package com.card.client.delivery;

import com.card.model.ShoppingCart;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/**
 * @author Kazim Unalan
 */
@FeignClient("delivery-server")
public interface DeliveryClient {

    @RequestMapping(
            method = RequestMethod.GET,
            value = "delivery"
    )
    @ResponseStatus(value = HttpStatus.OK)
    ResponseEntity<?> calculateDelivery(@RequestBody ShoppingCart shoppingCart);

}
