package org.example.coupon.template.api.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.stream.Stream;

/**
 * @Author : xuelong
 * @program
 * @description
 * @create 2023/9/8 15:00
 */
@Getter
@AllArgsConstructor
public enum CouponType {

    UNKOWN("unknown", "0"),
    MONEY_OFF("满减券", "1"),
    DISCOUNT("打折", "2"),
    RANDOM_DISCOUNT("随机减", "3"),
    NIGHT_MONEY_OFF("晚间双倍优惠券", "4");
//    NIGHT_MONEY_OFF("午夜下单优惠翻倍", "5");

    private final String description;
    private final String code;

    public static CouponType convert(String code) {
        return Stream.of(values())
                .filter(bean -> bean.code.equalsIgnoreCase(code))
                .findFirst()
                .orElse(UNKOWN);
    }
}
