package org.example.coupon.customer.api.beans;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author : xuelong
 * @program
 * @description
 * @create 2023/9/9 8:07
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchCoupon {

    /**
     * 用户id
     */
    @NotNull
    private Long userId;

    private Long shopId;

    private Integer couponStatus;
}
