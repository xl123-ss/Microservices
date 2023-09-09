package org.example.coupon.calculation.serverce.impl;

import com.alibaba.fastjson.JSON;
import com.example.coupon.calculation.api.beans.ShoppingCart;
import com.example.coupon.calculation.api.beans.SimulationOrder;
import com.example.coupon.calculation.api.beans.SimulationResponse;
import com.google.common.collect.Lists;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.example.coupon.calculation.serverce.CouponCalculationService;
import org.example.coupon.calculation.template.CouponTemplateFactory;
import org.example.coupon.calculation.template.RuleTemplate;
import org.example.coupon.template.api.beans.CouponInfo;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @Author : xuelong
 * @program
 * @description
 * @create 2023/9/9 8:00
 */
@Slf4j
@Service
public class CouponCalculationServiceImpl implements CouponCalculationService {

    @Resource
    private CouponTemplateFactory couponProcessorFactory;

    /**
     * 优惠券结算, 这里通过Factory类决定使用哪个底层Rule，底层规则对上层透明
     *
     * @param cart 购物车对象
     * @return 优惠券结算后的价格
     */
    @Override
    public ShoppingCart calculateOrderPrice(@RequestBody ShoppingCart cart) {
        log.info("calculate order price: {}", JSON.toJSONString(cart));
        RuleTemplate ruleTemplate = couponProcessorFactory.getTemplate(cart);
        return ruleTemplate.calculate(cart);
    }


    /**
     * 对所有优惠券进行试算，看哪个最省钱
     *
     * @param order 试算请求
     * @return 试算结果
     */
    @Override
    public SimulationResponse simulateOrder(@RequestBody SimulationOrder order) {
        SimulationResponse response = new SimulationResponse();
        long minOrderPrice = Long.MAX_VALUE;

        // 计算每一个优惠券的订单价格
        for (CouponInfo coupon : order.getCouponInfos()) {
            ShoppingCart cart = new ShoppingCart();
            cart.setProducts(order.getProducts());
            cart.setCouponInfos(Lists.newArrayList(coupon));
            cart = couponProcessorFactory.getTemplate(cart).calculate(cart);

            long couponId = coupon.getId();
            long orderPrice = cart.getCost();

            // 设置当前优惠券对应的订单价格
            response.getCouponToOrderPrice().put(couponId, orderPrice);

            // 比较订单价格，设置当前最优优惠券的ID
            if (minOrderPrice > orderPrice) {
                response.setBestCouponId(coupon.getId());
                minOrderPrice = orderPrice;
            }
        }
        return response;
    }
}
