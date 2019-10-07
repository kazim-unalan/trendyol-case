package com.product.model;

import com.product.model.base.BaseEntity;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @author Kazim Unalan
 */
@Entity
@Table(name = "main_category")
public class Product extends BaseEntity {

    @Column(name = "price")
    private Double price;

    @Column(name = "mainCategoryCode")
    private String mainCategoryCode;

    @Column(name = "subCategoryCode")
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
