package org.example.coupon.customer.api.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.coupon.template.api.enums.CouponType;

import java.util.stream.Stream;

/**
 * @Author : xuelong
 * @program
 * @description
 * @create 2023/9/9 8:25
 */
@Getter
@AllArgsConstructor
public enum CouponStatus {

    UNKOWN("UNKOWN", 0),
    AVAILABLE("AVAILABLE", 1),
    USED("USED", 2),
    INACTIVE("INACTIVE", 3);
//    NIGHT_MONEY_OFF("晚间双倍优惠券", 4);
//    NIGHT_MONEY_OFF("午夜下单优惠翻倍", "5");

    private final String description;
    private final Integer code;

    public static CouponStatus convert(Integer code) {
        return Stream.of(values())
                .filter(bean -> bean.code.equals(code))
                .findFirst()
                .orElse(UNKOWN);
    }

}
