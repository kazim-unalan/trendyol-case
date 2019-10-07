package com.discounts.dao.impl;

import com.discounts.model.Coupon;
import com.discounts.model.DiscountType;
import com.discounts.dao.CouponDao;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @author Kazim Unalan
 */
@Repository
public class CouponDaoImpl implements CouponDao {

    private static List<Coupon> COUPON = null;

    @PostConstruct
    public void init() {
        COUPON = Arrays.asList(new Coupon("coupon", "Coupon", new BigDecimal(100), 10.0d, DiscountType.RATE));
    }

    @Override
    public Optional<Coupon> findCoupon(String code) {
        return COUPON.stream().filter(coupon -> coupon.getCode().equals(code)).findFirst();
    }

    @Override
    public List<Coupon> findAllCoupons() {
        return COUPON;
    }

}
