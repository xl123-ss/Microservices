package org.example.coupon.calculation.template.impl;

import com.example.coupon.calculation.api.beans.ShoppingCart;
import lombok.extern.slf4j.Slf4j;
import org.example.coupon.calculation.template.AbstractRuleTemplate;
import org.example.coupon.calculation.template.RuleTemplate;
import org.springframework.stereotype.Component;

import java.util.Calendar;

/**
 * @Author : xuelong
 * @program
 * @description
 * @create 2023/9/8 16:51
 */
@Slf4j
@Component
public class DummyTemplate extends AbstractRuleTemplate implements RuleTemplate {
    @Override
    protected Long calculateNewPrice(Long orderTotalAmount, Long shopTotalAmount, Long quota) {
        return orderTotalAmount;
    }

    @Override
    public ShoppingCart calculate(ShoppingCart order) {
        Long orderTotalAmount = getTotalPrice(order.getProducts());
        order.setCost(orderTotalAmount);
        return order;
    }
}
