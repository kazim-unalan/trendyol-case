package com.category.client.product;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Kazim Unalan
 */
@FeignClient("product-server")
public interface ProductClient {

    @RequestMapping(
            method = RequestMethod.GET,
            value = "product"
    )
    @ResponseBody
    List<?> getAllProductsBySubCategoryCode(@RequestParam(value = "mainCategoryCode") String mainCategoryCode, @RequestParam(value = "subCategoryCode") String subCategoryCode);
}
