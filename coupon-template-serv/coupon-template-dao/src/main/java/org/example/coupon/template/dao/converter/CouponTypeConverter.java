package org.example.coupon.template.dao.converter;

import jakarta.persistence.AttributeConverter;
import org.example.coupon.template.api.enums.CouponType;

/**
 * @Author : xuelong
 * @program
 * @description
 * @create 2023/9/8 15:42
 */
public class CouponTypeConverter implements AttributeConverter<CouponType,String> {
    @Override
    public String convertToDatabaseColumn(CouponType couponType) {
        return couponType.getCode();
    }

    @Override
    public CouponType convertToEntityAttribute(String code) {
        return CouponType.convert(code);
    }
}
