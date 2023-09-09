package org.example.coupon.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Author : xuelong
 * @program
 * @description
 * @create 2023/9/9 8:02
 */
@SpringBootApplication
@EnableJpaAuditing
@ComponentScan(basePackages = {"org.example"})
@EnableTransactionManagement
//用于扫描dao @Repository
@EnableJpaRepositories(basePackages = {"org.example"})
//用于扫描JPA实体类，@Entity 默认扫本包当下路径
@EntityScan(basePackages = {"org.example"})
public class CustomerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerApplication.class, args);
    }
}
