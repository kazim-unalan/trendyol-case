package com.discounts.controller;

import com.discounts.model.*;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.*;

/**
 * @author Kazim Unalan
 */
@Controller
@RestController
@RequestMapping(value = "discount")
public class DiscountController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DiscountController.class);

    @HystrixCommand(fallbackMethod = "calculateCampaignDiscountFallBack", raiseHystrixExceptions = {HystrixException.RUNTIME_EXCEPTION})
    @RequestMapping(
            method = RequestMethod.GET,
            headers = "Accept=application/json",
            value = "/campaign"
    )
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    public ShoppingCart calculateCampaignDiscount(@RequestBody ShoppingCart shoppingCart) {
        List<Product> productList = shoppingCart.getProductCodeList();
        Campaign campaign = null;
        List<Product> tempProductList = new ArrayList<>();
        if (productList.size() <= 5 && productList.size() > 3) {
            campaign = new Campaign("campaign", "campaign", "food", "fruit", 20.0d, 3, DiscountType.RATE);
        } else if (productList.size() > 5) {
            campaign = new Campaign("campaign", "campaign", "food", "fruit", 50.0d, 5, DiscountType.RATE);
        }
        //another campaign rule 5 TL amount discount on a category if bought more than  items
//        else {
//            campaign = new Campaign("campaign", "campaign", "food", "fruit", 5.0f, 5, DiscountType.AMOUNT);
//        }

        Double totalCount = new Double(0);
        for (Product product : productList) {
            totalCount = totalCount + (product.getPrice());
        }
        shoppingCart.setSubTotalPrice(totalCount);
        shoppingCart.setCampaignDiscount(campaign.getDiscountRate());
        return shoppingCart;
    }


    @HystrixCommand(fallbackMethod = "calculateCouponDiscountFallBack", raiseHystrixExceptions = {HystrixException.RUNTIME_EXCEPTION})
    @RequestMapping(
            method = RequestMethod.GET,
            headers = "Accept=application/json",
            value = "/coupon"
    )
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    public ShoppingCart calculateCouponDiscount(@RequestBody ShoppingCart shoppingCart) {
        Coupon coupon = new Coupon("coupon", "Coupon", new BigDecimal(100), 10.0d, DiscountType.RATE);
        if (shoppingCart.getSubTotalPrice() > 100) {
            shoppingCart.setApplyCouponCode(coupon.getCode());
            shoppingCart.setCouponDiscount(coupon.getDiscountRate());
        } else {
            shoppingCart.setApplyCouponCode("");
            shoppingCart.setCouponDiscount(0d);
        }
        return shoppingCart;
    }

    public ShoppingCart calculateCampaignDiscountFallBack(@RequestBody ShoppingCart shoppingCart) {
        return shoppingCart;
    }

    public ShoppingCart calculateCouponDiscountFallBack(@RequestBody ShoppingCart shoppingCart) {
        return shoppingCart;
    }

}
