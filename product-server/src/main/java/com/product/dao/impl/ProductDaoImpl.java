package com.product.dao.impl;

import com.product.dao.ProductDao;
import com.product.model.Product;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Kazim Unalan
 */
@Repository
public class ProductDaoImpl implements ProductDao {

    private static List<Product> products = null;

    @PostConstruct
    public void init() {
        products = Arrays.asList(new Product("apple", "Apple", 100.0d, "food", "fruit"), new Product("almond", "Almond", 100.0d, "food", "vegetables"));
    }

    @Override
    public Product findProduct(String code) {
        Optional<Product> productList = products.stream().filter(product -> product.getCode().equals(code)).findFirst();
        return productList.get();
    }

    @Override
    public List<Product> findAllProducts() {
        return products;
    }

    @Override
    public List<Product> findAllProductByMainCategoryCode(String code) {
        return products.stream().filter(product -> product.getMainCategoryCode().equals(code)).collect(Collectors.toList());
    }

    @Override
    public List<Product> findAllProductBySubCategoryCode(String mainCategoryCode, String subCategoryCode) {
        return products.stream().filter(product -> product.getMainCategoryCode().equals(mainCategoryCode) && product.getSubCategoryCode().equals(subCategoryCode)).collect(Collectors.toList());
    }


}
