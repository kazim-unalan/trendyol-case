package com.front.controller;

import com.front.client.cart.CartClient;
import com.front.client.category.CategoryClient;
import com.front.model.ShoppingCart;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * @author Kazim Unalan
 */
@Controller
@RestController
@RequestMapping(value = "front")
//@ComponentScan("com.front.client.cart")
public class FrontController {

    private static final Logger LOGGER = LoggerFactory.getLogger(FrontController.class);

    private final static List<String> PRODUCT_LIST = null;

    @Autowired
    private CartClient cartClient;

    @Autowired
    private CategoryClient categoryClient;

    @HystrixCommand(fallbackMethod = "addToProductOnCartFallBack", raiseHystrixExceptions = {HystrixException.RUNTIME_EXCEPTION})
    @RequestMapping(
            method = RequestMethod.POST,
            headers = "Accept=application/json",
            value = "/cart/code"
    )
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    public ShoppingCart addToProductOnCart(@RequestParam(value = "cartCode") String cartCode, @RequestParam(value = "code") String code, @RequestParam(value = "count") Integer count) {
        LOGGER.info("addProductToCart");
        ShoppingCart shoppingCart = cartClient.addProductShoppingCart(cartCode, code, count);
        return shoppingCart;
    }

    @RequestMapping(
            method = RequestMethod.GET,
            headers = "Accept=application/json",
            value = "/product"
    )
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    public List<?> getProduct(@RequestBody Map<String, String> requestBody, HttpServletRequest request, HttpServletResponse response) {
        LOGGER.info("getCategory");
        String mainCategoryCode = requestBody.get("mainCategoryCode");
        String subCategoryCode = requestBody.get("subCategoryCode");

        return categoryClient.getAllSubCategoriesByMainCategoryCodeAndSubCategoryCode(mainCategoryCode, subCategoryCode);
    }

    public ShoppingCart addToProductOnCartFallBack(@RequestParam(value = "cartCode") String cartCode, @RequestParam(value = "code") String code, @RequestParam(value = "count") Integer count) {
        return null;
    }

    //ribbon netflix loadbalancer client

}
