package com.discounts.model;

import com.discounts.model.base.BaseEntity;

import java.util.List;

/**
 * @author Kazim Unalan
 */
public class ShoppingCart extends BaseEntity {

    private List<Product> productCodeList;

    private List<String> applyDiscountsCodes;

    private String applyCouponCode;

    private Double totalAmountAfterDiscounts;

    private Double couponDiscount;

    private Double campaignDiscount;

    private Double deliveryCost;

    private Double subTotalPrice;

    private Double totalPrice;


    public ShoppingCart() {
    }

    public ShoppingCart(String code, String name, List<Product> productCodeList, List<String> applyDiscountsCodes, String applyCouponCode, Double totalAmountAfterDiscounts, Double couponDiscount, Double campaignDiscount, Double deliveryCost, Double subTotalPrice, Double totalPrice) {
        super(code, name);
        this.productCodeList = productCodeList;
        this.applyDiscountsCodes = applyDiscountsCodes;
        this.applyCouponCode = applyCouponCode;
        this.totalAmountAfterDiscounts = totalAmountAfterDiscounts;
        this.couponDiscount = couponDiscount;
        this.campaignDiscount = campaignDiscount;
        this.deliveryCost = deliveryCost;
        this.subTotalPrice = subTotalPrice;
        this.totalPrice = totalPrice;
    }

    public List<Product> getProductCodeList() {
        return productCodeList;
    }

    public void setProductCodeList(List<Product> productCodeList) {
        this.productCodeList = productCodeList;
    }

    public List<String> getApplyDiscountsCodes() {
        return applyDiscountsCodes;
    }

    public void setApplyDiscountsCodes(List<String> applyDiscountsCodes) {
        this.applyDiscountsCodes = applyDiscountsCodes;
    }

    public String getApplyCouponCode() {
        return applyCouponCode;
    }

    public void setApplyCouponCode(String applyCouponCode) {
        this.applyCouponCode = applyCouponCode;
    }

    public Double getTotalAmountAfterDiscounts() {
        return totalAmountAfterDiscounts;
    }

    public void setTotalAmountAfterDiscounts(Double totalAmountAfterDiscounts) {
        this.totalAmountAfterDiscounts = totalAmountAfterDiscounts;
    }

    public Double getCouponDiscount() {
        return couponDiscount;
    }

    public void setCouponDiscount(Double couponDiscount) {
        this.couponDiscount = couponDiscount;
    }

    public Double getCampaignDiscount() {
        return campaignDiscount;
    }

    public void setCampaignDiscount(Double campaignDiscount) {
        this.campaignDiscount = campaignDiscount;
    }

    public Double getDeliveryCost() {
        return deliveryCost;
    }

    public void setDeliveryCost(Double deliveryCost) {
        this.deliveryCost = deliveryCost;
    }

    public Double getSubTotalPrice() {
        return subTotalPrice;
    }

    public void setSubTotalPrice(Double subTotalPrice) {
        this.subTotalPrice = subTotalPrice;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
