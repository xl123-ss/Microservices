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
 * @create 2023/9/8 16:40
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SimulationOrder {
    @NotNull
    private List<Product> products;
    @NotNull
    private List<Long> couponIDs;

    private List<CouponInfo> couponInfos;

    @NotNull
    private Long userId;
}
