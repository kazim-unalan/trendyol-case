package com.delivery.model;

import com.delivery.model.base.BaseEntity;

/**
 * @author Kazim Unalan
 */
public class Product extends BaseEntity {

    private Double price;

    private String mainCategoryCode;

    private String subCategoryCode;

    public Product() {
    }

    public Product(String code, String name, Double price, String mainCategoryCode, String subCategoryCode) {
        super(code, name);
        this.price = price;
        this.mainCategoryCode = mainCategoryCode;
        this.subCategoryCode = subCategoryCode;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getMainCategoryCode() {
        return mainCategoryCode;
    }

    public void setMainCategoryCode(String mainCategoryCode) {
        this.mainCategoryCode = mainCategoryCode;
    }

    public String getSubCategoryCode() {
        return subCategoryCode;
    }

    public void setSubCategoryCode(String subCategoryCode) {
        this.subCategoryCode = subCategoryCode;
    }
}
