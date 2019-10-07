package com.card.controller;

import com.card.client.delivery.DeliveryClient;
import com.card.client.discount.DiscountClient;
import com.card.client.product.ProductClient;
import com.card.model.Product;
import com.card.model.ShoppingCart;
import com.card.service.ShoppingCartService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


/**
 * @author Kazim Unalan
 */
@Controller
@RestController
@RequestMapping(value = "shopping-cart")
public class ShoppingCartController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ShoppingCartController.class);

    @Autowired
    private ShoppingCartService shoppingCartService;

    @Autowired
    private ProductClient productClient;

    @Autowired
    private DeliveryClient deliveryClient;

    @Autowired
    private DiscountClient discountClient;

    @HystrixCommand(fallbackMethod = "addProductShoppingCartFallBack", raiseHystrixExceptions = {HystrixException.RUNTIME_EXCEPTION})
    @RequestMapping(
            method = RequestMethod.GET,
            headers = "Accept=application/json",
            value = "/code"
    )
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    public ShoppingCart addProductShoppingCart(@RequestParam(value = "cartCode") String cartCode, @RequestParam(value = "code") String code, @RequestParam(value = "count") Integer count) {
        LOGGER.info("getProduct");
        Product product = productClient.getProduct(code);
        if (product != null) {
            ShoppingCart shoppingCart = shoppingCartService.addProductShoppingCart(cartCode, product, count);
            shoppingCart = discountClient.calculateCouponDiscount(shoppingCart);
            shoppingCart = calculateCampaign(shoppingCart);
            if (shoppingCart.getTotalPrice() > 100) {
                shoppingCart = discountClient.calculateCampaignDiscount(shoppingCart);
                shoppingCart = calculateCoupon(shoppingCart);
            }

            deliveryClient.calculateDelivery(shoppingCart);

            return shoppingCart;
        } else {
            return shoppingCartService.addProductShoppingCart(null, null, null);
        }
    }

    private ShoppingCart calculateCampaign(ShoppingCart shoppingCart) {
        Double campaignDiscount = shoppingCart.getCampaignDiscount();
        Double subTotalPrice = shoppingCart.getSubTotalPrice();
        shoppingCart.setTotalPrice(subTotalPrice - subTotalPrice % campaignDiscount);
        return shoppingCart;
    }

    private ShoppingCart calculateCoupon(ShoppingCart shoppingCart) {
        Double couponDiscount = shoppingCart.getCouponDiscount();
        Double totalPrice = shoppingCart.getTotalPrice();
        shoppingCart.setTotalPrice(totalPrice - totalPrice % couponDiscount);
        return shoppingCart;
    }

    @HystrixCommand(fallbackMethod = "getShoppingCartFallBack", raiseHystrixExceptions = {HystrixException.RUNTIME_EXCEPTION})
    @RequestMapping(
            method = RequestMethod.GET,
            headers = "Accept=application/json",
            value = "/get"
    )
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    public ShoppingCart getShoppingCart(@RequestParam(value = "code") String code) {
        LOGGER.info("getShoppingCart");
        return shoppingCartService.getShoppingCart(code);
    }

    public ShoppingCart addProductShoppingCartFallBack(@RequestParam(value = "cartCode") String cartCode, @RequestParam(value = "code") String code, @RequestParam(value = "count") Integer count) {
        return null;
    }

    public ShoppingCart getShoppingCartFallBack(@RequestParam(value = "code") String code) {
        return null;
    }

}
