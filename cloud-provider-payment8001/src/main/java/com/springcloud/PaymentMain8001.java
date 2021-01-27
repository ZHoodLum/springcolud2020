package com.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author：ZDY
 * @Date：Created in 2021/1/8
 * @Description:配置主启动类
 * 支付模块启动类
 * EnableEurekaClient 开启eureka
 * EnableDiscoveryClient 开启服务发现
 */

@SpringBootApplication
//@EnableEurekaClient
//@EnableDiscoveryClient
public class PaymentMain8001 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8001.class, args);
        System.out.println("访问8001路径：" + "http://127.0.0.1:8001/payment");
    }
}
