package org.example.coupon.template.converter;

import org.example.coupon.template.api.beans.CouponTemplateInfo;
import org.example.coupon.template.dao.enty.CouponTemplate;


/**
 * @Author : xuelong
 * @program
 * @description
 * @create 2023/9/8 15:59
 */
public class CouponTemplateConverter {

    public static CouponTemplateInfo convertToTemplateInfo(CouponTemplate template) {

        return CouponTemplateInfo.builder()
                .id(template.getId())
                .name(template.getName())
                .desc(template.getDescription())
                .type(template.getCategory().getCode())
                .shopId(template.getShopId())
                .available(template.getAvailable())
                .rule(template.getRule())
                .build();
    }
}
