package com.product.dao;

import com.product.model.Product;

import java.util.List;

/**
 * @author Kazim Unalan
 */
public interface ProductDao {

    Product findProduct(String code);

    List<Product> findAllProducts();

    List<Product> findAllProductByMainCategoryCode(String code);

    List<Product> findAllProductBySubCategoryCode(String mainCategoryCode, String subCategoryCode);


}
