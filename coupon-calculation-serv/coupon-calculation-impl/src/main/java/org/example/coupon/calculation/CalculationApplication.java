package org.example.coupon.calculation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Author : xuelong
 * @program
 * @description
 * @create 2023/9/9 8:02
 */
@SpringBootApplication
@ComponentScan(basePackages = {"org.example"})
public class CalculationApplication {

    public static void main(String[] args) {
        SpringApplication.run(CalculationApplication.class, args);
    }
}
