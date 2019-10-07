package com.card.model;

import com.card.model.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;

/**
 * @author Kazim Unalan
 */
@Entity
@Table(name = "shopping_cart")
public class ShoppingCart extends BaseEntity {

    @Column(name = "productCodeList")
    private List<Product> productCodeList;

    @Column(name = "applyDiscounts")
    private List<String> applyDiscountsCodes;

    @Column(name = "applyCouponCode")
    private String applyCouponCode;

    @Column(name = "totalAmountAfterDiscounts")
    private Double totalAmountAfterDiscounts;

    @Column(name = "couponDiscount")
    private Double couponDiscount;

    @Column(name = "campaignDiscount")
    private Double campaignDiscount;

    @Column(name = "deliveryCost")
    private Double deliveryCost;

    @Column(name = "subTotalPrice")
    private Double subTotalPrice;

    @Column(name = "totalPrice")
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
}
