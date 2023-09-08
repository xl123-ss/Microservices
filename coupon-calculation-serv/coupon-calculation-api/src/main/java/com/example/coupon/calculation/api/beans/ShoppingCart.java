package com.example.coupon.calculation.api.beans;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.coupon.template.api.beans.CouponInfo;

import java.util.List;

/**
 * @Author : xuelong
 * @program
 * @description
 * @create 2023/9/8 16:37
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShoppingCart {

    @NotNull
    private List<Product> products;


    private Long couponId;

    private Long cost;

    /**
     * 添加多个优惠券的计算逻辑，所以用List
     */
    private List<CouponInfo> couponInfos;
    @NotNull
    private Long userId;
}
