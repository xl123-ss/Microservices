package org.example.coupon.template.service.impl;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.example.coupon.template.api.beans.CouponTemplateInfo;
import org.example.coupon.template.api.beans.PagedCouponTemplateInfo;
import org.example.coupon.template.api.beans.TemplateSearchParams;
import org.example.coupon.template.api.enums.CouponType;
import org.example.coupon.template.converter.CouponTemplateConverter;
import org.example.coupon.template.dao.CouponTemplateDao;
import org.example.coupon.template.dao.enty.CouponTemplate;
import org.example.coupon.template.service.CouponTemplateService;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @Author : xuelong
 * @program
 * @description
 * @create 2023/9/8 15:57
 */
@Slf4j
@Service
public class CouponTemplateServiceImpl implements CouponTemplateService {

    @Resource
    private CouponTemplateDao templateDao;

    // 克隆优惠券
    @Override
    public CouponTemplateInfo cloneTemplate(Long templateId) {
        log.info("cloning template id {}", templateId);
        CouponTemplate source = templateDao.findById(templateId)
                .orElseThrow(() -> new IllegalArgumentException("invalid template ID"));

        CouponTemplate target = new CouponTemplate();
        BeanUtils.copyProperties(source, target);

        target.setAvailable(true);
        target.setId(null);

        templateDao.save(target);
        return CouponTemplateConverter.convertToTemplateInfo(target);
    }

    /**
     * 创建优惠券模板
     */
    @Override
    public CouponTemplateInfo createTemplate(CouponTemplateInfo request) {
        // 单个门店最多可以创建100张优惠券模板
        if (request.getShopId() != null) {
            Integer count = templateDao.countByShopIdAndAvailable(request.getShopId(), true);
            if (count >= 100) {
                log.error("the totals of coupon template exceeds maximum number");
                throw new UnsupportedOperationException("exceeded the maximum of coupon templates that you can create");
            }
        }

        // 创建优惠券
        CouponTemplate template = CouponTemplate.builder()
                .name(request.getName())
                .description(request.getDesc())
                .category(CouponType.convert(request.getType()))
                .available(true)
                .shopId(request.getShopId())
                .rule(request.getRule())
                .build();
        template = templateDao.save(template);

        return CouponTemplateConverter.convertToTemplateInfo(template);
    }

    @Override
    public PagedCouponTemplateInfo search(TemplateSearchParams request) {
        CouponTemplate example = CouponTemplate.builder()
                .shopId(request.getShopId())
                .category(CouponType.convert(request.getType()))
                .available(request.getAvailable())
                .name(request.getName())
                .build();

        Pageable page = PageRequest.of(request.getPage(), request.getPageSize());
        Page<CouponTemplate> result = templateDao.findAll(Example.of(example), page);
        List<CouponTemplateInfo> couponTemplateInfos = result.stream()
                .map(CouponTemplateConverter::convertToTemplateInfo)
                .collect(Collectors.toList());

        return PagedCouponTemplateInfo.builder()
                .templates(couponTemplateInfos)
                .page(request.getPage())
                .total(result.getTotalElements())
                .build();
    }

    public List<CouponTemplateInfo> searchTemplate(CouponTemplateInfo request) {
        CouponTemplate example = CouponTemplate.builder()
                .shopId(request.getShopId())
                .category(CouponType.convert(request.getType()))
                .available(request.getAvailable())
                .name(request.getName())
                .build();
        // 可以用下面的方式做分页查询
//        Pageable page = PageRequest.of(0, 100);
//        templateDao.findAll(Example.of(example), page);
        List<CouponTemplate> result = templateDao.findAll(Example.of(example));
        return result.stream()
                .map(CouponTemplateConverter::convertToTemplateInfo)
                .collect(Collectors.toList());
    }

    /**
     * 通过ID查询优惠券模板
     */
    @Override
    public CouponTemplateInfo loadTemplateInfo(Long id) {
        Optional<CouponTemplate> template = templateDao.findById(id);
        return template.map(CouponTemplateConverter::convertToTemplateInfo).orElse(null);
    }

    // 将券无效化
    @Override
    //@Transactional
    public void deleteTemplate(Long id) {
        int rows = templateDao.makeCouponUnavailable(id);
        if (rows == 0) {
            throw new IllegalArgumentException("Template Not Found: " + id);
        }
    }

    /**
     * 批量读取模板
     */
    @Override
    public Map<Long, CouponTemplateInfo> getTemplateInfoMap(Collection<Long> ids) {
        List<CouponTemplate> templates = templateDao.findAllById(ids);
        return templates.stream()
                .map(CouponTemplateConverter::convertToTemplateInfo)
                .collect(Collectors.toMap(CouponTemplateInfo::getId, Function.identity()));
    }
}
