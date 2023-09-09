package org.example.coupon.calculation.template.impl;

import lombok.extern.slf4j.Slf4j;
import org.example.coupon.calculation.template.AbstractRuleTemplate;
import org.example.coupon.calculation.template.RuleTemplate;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Random;

/**
 * @Author : xuelong
 * @program
 * @description
 * @create 2023/9/8 16:51
 */
@Slf4j
@Component
public class RandomReductionTemplate extends AbstractRuleTemplate implements RuleTemplate {
    @Override
    protected Long calculateNewPrice(Long orderTotalAmount, Long shopTotalAmount, Long quota) {
       long maxBenefit = Math.min(shopTotalAmount,quota);
       int reductionAmount = new Random().nextInt((int)maxBenefit);
       long newCost = shopTotalAmount-reductionAmount;
       log.debug("original price={},new price = {}",orderTotalAmount,newCost);
       return newCost;
    }
}
