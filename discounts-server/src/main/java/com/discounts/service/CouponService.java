package com.discounts.service;

import com.discounts.model.Coupon;

import java.util.List;
import java.util.Optional;

/**
 * @author Kazim Unalan
 */
public interface CouponService {

    Optional<Coupon> getCoupon(String code);

    List<Coupon> getAllCoupons();

}
