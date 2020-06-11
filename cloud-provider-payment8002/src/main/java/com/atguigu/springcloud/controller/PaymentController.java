package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Auther: yanyouming
 * @Date: 2020/5/2 21:45
 * @Description:
 */
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String servePort;

    @PostMapping(value = "/payment/create")
    public CommonResult creat(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        if(result > 0){
            CommonResult commonResult = new CommonResult(200, "插入数据成功,端口号："+servePort);
            commonResult.setData(result);
            return commonResult;
        }else {
            CommonResult commonResult = new CommonResult(444, "插入数据失败");
            System.out.println("插入数据失败");
            commonResult.setData(result);
            return commonResult;
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentByid(@PathVariable("id") Long id){
        Payment result = paymentService.getPaymentByid(id);
        if(result != null){
            CommonResult commonResult = new CommonResult(200, "查找数据成功,端口号："+servePort);
            System.out.println("查找数据成功");
            commonResult.setData(result);
            return commonResult;
        }else {
            CommonResult commonResult = new CommonResult(444, "插入数据失败");
            commonResult.setData(result);
            System.out.println("插入数据失败");
            return commonResult;
        }
    }

    @GetMapping(value = "/payment/lb")
    public String getPaymentLB(){
        return servePort;
    }
}
