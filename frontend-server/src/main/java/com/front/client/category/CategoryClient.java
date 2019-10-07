package com.front.client.category;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @author Kazim Unalan
 */
@FeignClient("category-server")
public interface CategoryClient {

    @RequestMapping(
            method = RequestMethod.GET,
            value = "categories"
    )
    @ResponseBody
    List<?> getAllSubCategoriesByMainCategoryCodeAndSubCategoryCode(@RequestParam(value = "mainCategoryCode") String mainCategoryCode, @RequestParam(value = "subCategoryCode") String subCategoryCode);
}
