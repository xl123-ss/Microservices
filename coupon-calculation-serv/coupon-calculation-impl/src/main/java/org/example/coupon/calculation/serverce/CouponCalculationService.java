package org.example.coupon.calculation.serverce;

import com.example.coupon.calculation.api.beans.ShoppingCart;
import com.example.coupon.calculation.api.beans.SimulationOrder;
import com.example.coupon.calculation.api.beans.SimulationResponse;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @Author : xuelong
 * @program
 * @description
 * @create 2023/9/9 7:56
 */
public interface CouponCalculationService {


    /**
     * 订单价格计算
     * @param cart 购物车
     * @return 计算结果
     */
    ShoppingCart calculateOrderPrice(@RequestBody ShoppingCart cart);

    /**
     * 订单价格试算
     * @param cart 购物车
     * @return 试算结果
     */
    SimulationResponse simulateOrder(@RequestBody SimulationOrder cart);
}
