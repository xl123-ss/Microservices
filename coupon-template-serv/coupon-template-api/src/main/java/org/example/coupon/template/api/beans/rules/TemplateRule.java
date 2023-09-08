package org.example.coupon.template.api.beans.rules;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author : xuelong
 * @program
 * @description
 * @create 2023/9/8 15:07
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TemplateRule {
    /**
     * 可以享受的折扣
     */
    private Discount discount;

    /**
     * 每个人最多可以领券的数量
     */
    private Integer limitation;

    /**
     * 过期时间
     */
    private Long deadline;

}
