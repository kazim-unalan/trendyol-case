package com.discounts.model;


import com.discounts.model.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * @author Kazim Unalan
 */
@Entity
@Table(name = "coupon")
public class Coupon extends BaseEntity {

    @Column(name = "totalPrice")
    private BigDecimal totalPrice;

    private Double discountRate;

    @Column(name = "discountType")
    private DiscountType discountType;

    public Coupon() {
    }

    public Coupon(String code, String name, BigDecimal totalPrice, Double discountRate, DiscountType discountType) {
        super(code, name);
        this.totalPrice = totalPrice;
        this.discountRate = discountRate;
        this.discountType = discountType;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
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
