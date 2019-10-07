package com.discounts.model;


import com.discounts.model.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author Kazim Unalan
 */
@Entity
@Table(name = "shopping_cart")
public class Campaign extends BaseEntity {

    @Column(name = "mainCategoryCode")
    private String mainCategoryCode;

    @Column(name = "subCategoryCode")
    private String subCategoryCode;

    @Column(name = "productCount")
    private Integer productCount;

    @Column(name = "discountRate")
    private Double discountRate;

    @Column(name = "discountType")
    private DiscountType discountType;

    public Campaign() {
    }

    public Campaign(String code, String name, String mainCategoryCode, String subCategoryCode, Double discountRate, Integer productCount, DiscountType discountType) {
        super(code, name);
        this.mainCategoryCode = mainCategoryCode;
        this.subCategoryCode = subCategoryCode;
        this.discountRate = discountRate;
        this.productCount = productCount;
        this.discountType = discountType;
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

    public Integer getProductCount() {
        return productCount;
    }

    public void setProductCount(Integer productCount) {
        this.productCount = productCount;
    }

    public Double getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(Double discountRate) {
        this.discountRate = discountRate;
    }

    public DiscountType getDiscountType() {
        return discountType;
    }

    public void setDiscountType(DiscountType discountType) {
        this.discountType = discountType;
    }
}
