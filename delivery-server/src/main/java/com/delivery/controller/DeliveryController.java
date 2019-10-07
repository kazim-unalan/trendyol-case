package com.delivery.controller;

import com.delivery.model.DeliveryCostCalculator;
import com.delivery.model.ShoppingCart;
import com.delivery.service.DeliveryCostCalculatorService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author Kazim Unalan
 */
@Controller
@RestController
@RequestMapping(value = "delivery")
public class DeliveryController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DeliveryController.class);

    @Autowired
    private DeliveryCostCalculatorService deliveryCostCalculatorService;

    @HystrixCommand(fallbackMethod = "calculateForFallBack", raiseHystrixExceptions = {HystrixException.RUNTIME_EXCEPTION})
    @RequestMapping(
            method = RequestMethod.GET,
            headers = "Accept=application/json",
            value = "/calculate"
    )
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    public Double calculateFor(@RequestBody ShoppingCart shoppingCart) {
        LOGGER.info("calculateFor");

        //??
        return null;

    }

    public Double calculateForFallBack(@RequestBody ShoppingCart shoppingCart) {
        return null;
    }


}
