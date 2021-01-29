package com.springcloud.controller;

import com.springcloud.entity.CommonResult;
import com.springcloud.entity.Payment;
import com.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @ Author     ：Psyduckzzzz
 * @ Date       ：Created in 2021/1/26
 */


@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    //获取配置类中的端口信息
    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value = "/addPayment")
    public CommonResult addPayment(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("addPayment插入结果：" + result);
        if (result > 0) {  //成功
            return new CommonResult(200, "插入数据库成功" + serverPort, result);
        } else {
            return new CommonResult(444, "插入数据库失败" + serverPort, null);
        }
    }

    //请求方式一
    @GetMapping(value = "/getPaymentById")
    public CommonResult getPaymentById(@RequestParam("id") Integer id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("getPaymentById查询结果：" + payment);
        if (payment != null) {  //说明有数据，能查询成功
            return new CommonResult(200, "查询成功" + serverPort, payment);
        } else {
            return new CommonResult(444, serverPort + "没有对应记录，查询ID：" + id, null);
        }
    }

    //请求方式二
    @GetMapping(value = "/getPaymentById2/{id}")
    public CommonResult getPaymentById2(@PathVariable("id") Integer id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("getPaymentById查询结果：" + payment);
        if (payment != null) {  //说明有数据，能查询成功
            return new CommonResult(200, "查询成功" + serverPort, payment);
        } else {
            return new CommonResult(444, serverPort + "没有对应记录，查询ID：" + id, null);
        }
    }

}