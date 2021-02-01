package com.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @ Author     ：Psyduckzzzz
 * @ Date       ：Created in 2021/2/1
 */

@SpringBootApplication
@EnableDiscoveryClient
public class PaymentMain006 {
    public static void main(String[] args) {
          SpringApplication.run(PaymentMain006.class, args);
     }
}
