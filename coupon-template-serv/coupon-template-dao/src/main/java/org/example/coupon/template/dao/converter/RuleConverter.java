package org.example.coupon.template.dao.converter;

import com.alibaba.fastjson.JSON;
import jakarta.persistence.AttributeConverter;
import org.example.coupon.template.api.beans.rules.TemplateRule;
import org.example.coupon.template.api.enums.CouponType;

/**
 * @Author : xuelong
 * @program
 * @description
 * @create 2023/9/8 15:42
 */
public class RuleConverter implements AttributeConverter<TemplateRule, String> {
    @Override
    public String convertToDatabaseColumn(TemplateRule rule) {
        return JSON.toJSONString(rule);
    }

    @Override
    public TemplateRule convertToEntityAttribute(String rule) {
        return JSON.parseObject(rule, TemplateRule.class);
    }
}
