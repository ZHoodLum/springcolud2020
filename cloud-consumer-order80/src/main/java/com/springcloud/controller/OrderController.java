package com.springcloud.controller;

import com.springcloud.entity.CommonResult;
import com.springcloud.entity.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @ Author     ：Psyduckzzzz
 * @ Date       ：Created in 2021/1/27
 */

@RestController
@Slf4j
@RequestMapping("/consumer")
public class OrderController {

    @Resource
    private RestTemplate restTemplate;

    public static final String PAYMENT_URL = "http://localhost:8001";

    @PostMapping("/payment/addPayment")
    public CommonResult<Payment> addPayment(@RequestBody Payment payment) {
        log.info("调用订单模块方法：payment/addPayment");
        return restTemplate.postForObject(PAYMENT_URL + "payment/addPayment", payment, CommonResult.class);
    }


    @GetMapping("/payment/getPaymentById")
    public CommonResult<Payment> getPaymentById(@RequestParam("id") Integer id) {
        log.info("调用订单模块方法：payment/getPaymentById");

        //请求方式一
        return restTemplate.getForObject(PAYMENT_URL + "/payment/getPaymentById?id=" + id, CommonResult.class);
        //请求方式二
        //return restTemplate.getForObject(PAYMENT_URL + "/payment/getPaymentById2/" + id, CommonResult.class);
    }

}

