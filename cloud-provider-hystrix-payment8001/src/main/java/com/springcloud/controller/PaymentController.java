package com.springcloud.controller;

import com.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * @Author:Psyduckzzzz
 * @Date:Created in 2021/2/4
 * @Description:
 */

@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/hystrix/ok")
    public String paymentInfo_OK(@RequestParam Integer id) {
        String result = paymentService.paymentInfo_OK(id);
        log.info("paymentInfo_OK--------result" + result);
        return result;
    }

    @GetMapping("/hystrix/timeout")
    public String paymentInfo_TimeOut(@RequestParam Integer id) {
        String result = paymentService.paymentInfo_TimeOut(id);
        log.info("paymentInfo_TimeOut--------result" + result);
        return result;
    }
}
