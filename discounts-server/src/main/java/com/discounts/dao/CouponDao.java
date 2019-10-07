package com.discounts.dao;

import com.discounts.model.Coupon;

import java.util.List;
import java.util.Optional;

/**
 * @author Kazim Unalan
 */
public interface CouponDao {

    Optional<Coupon> findCoupon(String code);

    List<Coupon> findAllCoupons();

}
