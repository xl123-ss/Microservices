package org.example.coupon.template;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * @Author : xuelong
 * @program
 * @description
 * @create 2023/9/8 15:53
 */
@SpringBootApplication
@EnableJpaAuditing
@ComponentScan("org.example")
public class TemplateApplication {
    public static void main(String[] args) {
        SpringApplication.run(TemplateApplication.class,args);
    }
}
