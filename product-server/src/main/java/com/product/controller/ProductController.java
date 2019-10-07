package com.product.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixException;
import com.product.model.Product;
import com.product.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

/**
 * @author Kazim Unalan
 */
@Controller
@RestController
@RequestMapping(value = "product")
public class ProductController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService productService;

    @HystrixCommand(fallbackMethod = "getProductFallBack", raiseHystrixExceptions = {HystrixException.RUNTIME_EXCEPTION})
    @RequestMapping(
            method = RequestMethod.GET,
            headers = "Accept=application/json",
            value = "/code"
    )
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    public Product getProduct(@RequestParam(value = "code") String code) {
        LOGGER.info("getProduct");
        return productService.getProduct(code);
    }

    @HystrixCommand(fallbackMethod = "getAllProductsBySubCategoryCodeFallBack", raiseHystrixExceptions = {HystrixException.RUNTIME_EXCEPTION})
    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(
            method = RequestMethod.GET,
            headers = "Accept=application/json"
    )
    @ResponseBody
    public List<Product> getAllProductsBySubCategoryCode(@RequestParam(value = "mainCategoryCode") String mainCategoryCode, @RequestParam(value = "subCategoryCode") String subCategoryCode) {
        LOGGER.info("getAllProductsBySubCategoryCode");
        return productService.getAllProductBySubCategoryCode(mainCategoryCode, subCategoryCode);
    }

    public List<Product> getAllProductsBySubCategoryCodeFallBack(@RequestParam(value = "mainCategoryCode") String mainCategoryCode, @RequestParam(value = "subCategoryCode") String subCategoryCode) {
        return Collections.emptyList();
    }

    public Product getProductFallBack(@RequestParam(value = "code") String code) {
        return null;
    }

}
