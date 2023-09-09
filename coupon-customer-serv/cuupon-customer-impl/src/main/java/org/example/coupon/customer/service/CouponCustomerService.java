package org.example.coupon.customer.service;

import com.example.coupon.calculation.api.beans.ShoppingCart;
import com.example.coupon.calculation.api.beans.SimulationOrder;
import com.example.coupon.calculation.api.beans.SimulationResponse;
import org.example.coupon.customer.api.beans.RequestCoupon;
import org.example.coupon.customer.api.beans.SearchCoupon;
import org.example.coupon.customer.dao.entity.Coupon;
import org.example.coupon.template.api.beans.CouponInfo;

import java.util.List;

/**
 * @Author : xuelong
 * @program
 * @description
 * @create 2023/9/9 8:39
 */
public interface CouponCustomerService {

    /**
     * 领券接口
     *
     * @param request 请求对象
     * @return 优惠券
     */
    Coupon requestCoupon(RequestCoupon request);

    /**
     * 核销优惠券
     *
     * @param info 优惠券信息
     * @return 优惠券
     */
    ShoppingCart placeOrder(ShoppingCart info);

    /**
     * 优惠券金额试算
     *
     * @param order 订单信息
     * @return 优惠券
     */
    SimulationResponse simulateOrderPrice(SimulationOrder order);

    void deleteCoupon(Long userId, Long couponId);

    /**
     * 查询用户优惠券
     *
     * @param request 请求对象
     * @return 优惠券
     */
    List<CouponInfo> findCoupon(SearchCoupon request);
}
