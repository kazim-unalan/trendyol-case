package com.category.controller;

import com.category.client.product.ProductClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

/**
 * @author Kazim Unalan
 */
@Controller
@RestController
public class CategoryController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CategoryController.class);


    @Autowired
    private ProductClient productClient;

    @HystrixCommand(fallbackMethod = "categoryFallBack", raiseHystrixExceptions = {HystrixException.RUNTIME_EXCEPTION})
    @RequestMapping(
            method = RequestMethod.GET,
            headers = "Accept=application/json",
            value = "categories"
    )
    @ResponseBody
    public List<?> getAllSubCategoriesByMainCategoryCodeAndSubCategoryCode(@RequestParam(value = "mainCategoryCode") String mainCategoryCode, @RequestParam(value = "subCategoryCode") String subCategoryCode) {
        LOGGER.info("getAllSubCategoriesByMainCategoryCodeAndSubCategoryCode");
        return productClient.getAllProductsBySubCategoryCode(mainCategoryCode, subCategoryCode);
    }


    public List<?> categoryFallBack(@RequestParam(value = "mainCategoryCode") String mainCategoryCode, @RequestParam(value = "subCategoryCode") String subCategoryCode) {
        return Collections.emptyList();
    }


}
