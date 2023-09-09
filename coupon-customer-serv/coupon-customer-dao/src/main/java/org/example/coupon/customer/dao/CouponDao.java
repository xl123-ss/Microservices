package org.example.coupon.customer.dao;

import org.example.coupon.customer.dao.entity.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author : xuelong
 * @program
 * @description
 * @create 2023/9/9 8:26
 */
public interface CouponDao extends JpaRepository<Coupon,Long> {
    Long countByUserIdAndTemplateId(Long userId, Long templateId);
}
