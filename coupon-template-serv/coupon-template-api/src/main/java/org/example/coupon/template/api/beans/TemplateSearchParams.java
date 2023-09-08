package org.example.coupon.template.api.beans;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author : xuelong
 * @program
 * @description
 * @create 2023/9/8 15:17
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TemplateSearchParams {
    private Long id;
    private String name;
    private String type;
    private Long shopId;
    private Boolean available;
    private int page;
    private int pageSize;
}
