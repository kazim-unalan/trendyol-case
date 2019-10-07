package com.card.client.discount;

import com.card.model.ShoppingCart;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Kazim Unalan
 */
@FeignClient("discount-server")
public interface DiscountClient {

    @RequestMapping(
            method = RequestMethod.GET,
            value = "discount/campaign"
    )
    @ResponseStatus(value = HttpStatus.OK)
    ShoppingCart calculateCampaignDiscount(@RequestBody ShoppingCart shoppingCart);

    @RequestMapping(
            method = RequestMethod.GET,
            value = "discount/coupon"
    )
    @ResponseStatus(value = HttpStatus.OK)
    ShoppingCart calculateCouponDiscount(@RequestBody ShoppingCart shoppingCart);
}
