package com.product.service.impl;

import com.product.dao.ProductDao;
import com.product.model.Product;
import com.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Kazim Unalan
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public Product getProduct(String code) {
        return productDao.findProduct(code);
    }

    @Override
    public List<Product> getAllProducts() {
        return productDao.findAllProducts();
    }

    @Override
    public List<Product> getAllProductByMainCategoryCode(String code) {
        return productDao.findAllProductByMainCategoryCode(code);
    }

    @Override
    public List<Product> getAllProductBySubCategoryCode(String mainCategoryCode, String subCategoryCode) {
        return productDao.findAllProductBySubCategoryCode(mainCategoryCode, subCategoryCode);
    }
}
