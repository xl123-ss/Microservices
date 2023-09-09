package org.example.coupon.customer.dao.converter;

import jakarta.persistence.AttributeConverter;
import org.example.coupon.customer.api.enums.CouponStatus;
import org.example.coupon.customer.dao.entity.Coupon;
import org.example.coupon.template.api.beans.CouponInfo;
import org.example.coupon.template.api.enums.CouponType;

/**
 * @Author : xuelong
 * @program
 * @description
 * @create 2023/9/9 8:21
 */
public class CouponStatusConverter implements AttributeConverter<CouponStatus, Integer> {


    @Override
    public Integer convertToDatabaseColumn(CouponStatus couponStatus) {
        return couponStatus.getCode();
    }

    @Override
    public CouponStatus convertToEntityAttribute(Integer code) {
        return CouponStatus.convert(code);
    }
}
