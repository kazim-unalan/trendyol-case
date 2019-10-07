package com.product.service;

import com.product.model.Product;

import java.util.List;

/**
 * @author Kazim Unalan
 */
public interface ProductService {

    Product getProduct(String code);

    List<Product> getAllProducts();

    List<Product> getAllProductByMainCategoryCode(String mainCategoryCode);

    List<Product> getAllProductBySubCategoryCode(String mainCategoryCode, String subCategoryCode);

}
