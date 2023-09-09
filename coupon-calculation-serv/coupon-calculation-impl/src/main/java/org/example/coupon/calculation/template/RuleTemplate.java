package org.example.coupon.calculation.template;

import com.example.coupon.calculation.api.beans.ShoppingCart;

/**
 * @Author : xuelong
 * @program
 * @description
 * @create 2023/9/8 16:49
 */
public interface RuleTemplate {
    ShoppingCart calculate(ShoppingCart settlement);
}
