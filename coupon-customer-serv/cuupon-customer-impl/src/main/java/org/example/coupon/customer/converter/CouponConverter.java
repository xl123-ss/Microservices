package org.example.coupon.customer.converter;

import org.example.coupon.customer.dao.entity.Coupon;
import org.example.coupon.template.api.beans.CouponInfo;

/**
 * @Author : xuelong
 * @program
 * @description
 * @create 2023/9/9 8:34
 */
public class CouponConverter {

    public static CouponInfo convertToCoupon(Coupon coupon) {

        return CouponInfo.builder()
                .id(coupon.getId())
                .status(coupon.getStatus().getCode())
                .shopId(coupon.getShopId())
                .userId(coupon.getUserId())
                .template(coupon.getTemplateInfo())
                .build();
    }
}
