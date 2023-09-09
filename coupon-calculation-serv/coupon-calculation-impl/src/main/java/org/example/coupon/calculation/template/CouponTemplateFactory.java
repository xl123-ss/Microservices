package org.example.coupon.calculation.template;

import com.example.coupon.calculation.api.beans.ShoppingCart;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.example.coupon.calculation.template.impl.*;
import org.example.coupon.template.api.beans.CouponTemplateInfo;
import org.example.coupon.template.api.enums.CouponType;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

/**
 * @Author : xuelong
 * @program
 * @description CouponTemplateFactory——工厂方法根据订单中的优惠券信息，返回对应的Template用于计算优惠价
 * @create 2023/9/9 7:52
 */
@Component
@Slf4j
public class CouponTemplateFactory {

    @Resource
    private MoneyOffTemplate moneyOffTemplate;

    @Resource
    private DiscountTemplate discountTemplate;

    @Resource
    private RandomReductionTemplate randomReductionTemplate;

    @Resource
    private NightTemplate nightTemplate;

    @Resource
    private DummyTemplate dummyTemplate;


    public RuleTemplate getTemplate(ShoppingCart order) {
        // 不使用优惠券
        if (!CollectionUtils.isEmpty(order.getCouponInfos())) {// 获取优惠券的类别
            // 目前每个订单只支持单张优惠券
            CouponTemplateInfo template = order.getCouponInfos().get(0).getTemplate();
            CouponType category = CouponType.convert(template.getType());

            return switch (category) {
                // 订单满减券
                case MONEY_OFF -> moneyOffTemplate;
                // 随机立减券
                case RANDOM_DISCOUNT -> randomReductionTemplate;
                // 午夜下单优惠翻倍
                case NIGHT_MONEY_OFF -> nightTemplate;
                // 打折券
                case DISCOUNT -> discountTemplate;
                // 未知类型的券模板
                default -> dummyTemplate;
            };
        } else {
            // dummy模板直接返回原价，不进行优惠计算
            return dummyTemplate;
        }

    }

}

