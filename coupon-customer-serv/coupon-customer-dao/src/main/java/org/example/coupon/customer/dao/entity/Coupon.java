package org.example.coupon.customer.dao.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.coupon.customer.api.enums.CouponStatus;
import org.example.coupon.customer.dao.converter.CouponStatusConverter;
import org.example.coupon.template.api.beans.CouponTemplateInfo;
import org.springframework.data.annotation.CreatedDate;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import jakarta.persistence.*;

import java.util.Date;

/**
 * @Author : xuelong
 * @program
 * @description
 * @create 2023/9/9 8:21
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "coupon")
public class Coupon {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    /**
     * 对应的模板 ID - 不使用 one to one 映射
     * 不推荐使用级联查询的原因是为了防止滥用而导致的 DB 性能问题
     */
    @Column(name = "template_id", nullable = false)
    private Long templateId;

    /**
     * 所有者的用户 id
     */
    @Column(name = "user_id", nullable = false)
    private Long userId;

    /**
     * 冗余一个 shop id 方便查找
     */
    @Column(name = "shop_id")
    private Long shopId;

    /**
     * 优惠券的使用/未使用状态
     */
    @Column(name = "status", nullable = false)
    @Convert(converter = CouponStatusConverter.class)
    private CouponStatus status;

    /**
     * 被 Transient 标记的属性是不会被持久化的
     */
    @Transient
    private CouponTemplateInfo templateInfo;

    /**
     * 获取时间自动生成
     */
    @CreatedDate
    @Column(name = "created_time", nullable = false)
    private Date createdTime;
}
