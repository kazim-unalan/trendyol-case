package com.discounts.service.impl;

import com.discounts.model.Coupon;
import com.discounts.dao.CouponDao;
import com.discounts.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Kazim Unalan
 */
@Service
public class CouponServiceImpl implements CouponService {

    @Autowired
    private CouponDao campaignDao;


    @Override
    public Optional<Coupon> getCoupon(String code) {
        return campaignDao.findCoupon(code);
    }

    @Override
    public List<Coupon> getAllCoupons() {
        return campaignDao.findAllCoupons();
    }
}
