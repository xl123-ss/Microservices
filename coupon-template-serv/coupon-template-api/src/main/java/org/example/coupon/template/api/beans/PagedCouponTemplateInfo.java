package org.example.coupon.template.api.beans;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author : xuelong
 * @program
 * @description
 * @create 2023/9/8 15:16
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PagedCouponTemplateInfo {
    public List<CouponTemplateInfo> templates;

    public int page;

    public long total;
}
