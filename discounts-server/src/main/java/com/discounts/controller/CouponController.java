package com.discounts.controller;

import com.discounts.model.Coupon;
import com.discounts.service.CouponService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

/**
 * @author Kazim Unalan
 */
@Controller
@RestController
@RequestMapping(value = "coupon")
public class CouponController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CouponController.class);

    @Autowired
    private CouponService couponService;

    @RequestMapping(
            method = RequestMethod.GET,
            headers = "Accept=application/json",
            value = "/code"
    )
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    public Optional<Coupon> getCoupon(@RequestParam(value = "code") String code, HttpServletRequest request, HttpServletRequest response) {
        LOGGER.info("getCoupon");
        return couponService.getCoupon(code);
    }

    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(
            method = RequestMethod.GET,
            headers = "Accept=application/json",
            value = "/coupons"
    )
    @ResponseBody
    public List<Coupon> getAllCoupons(HttpServletRequest request, HttpServletRequest response) {
        LOGGER.info("getAllCoupons");
        return couponService.getAllCoupons();
    }


}
