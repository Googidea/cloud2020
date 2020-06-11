package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.lb.LoadBalanced;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import javax.print.DocFlavor;
import java.net.URI;
import java.util.List;

/**
 * @Auther: yanyouming
 * @Date: 2020/5/3 09:32
 * @Description:
 */
@RestController
@Slf4j
public class PaymentController {
//    private final static String PAYMENT_URL = "http://127.0.0.1:8001";
      private final static String PAYMENT_URL = "http://CLOUD-PROVIDER-SERVICE";
    @Resource
    private RestTemplate template;

    @Resource
    private DiscoveryClient discoveryClient;

    @Resource
    private LoadBalanced loadBalanced;

    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment){

        return template.postForObject(PAYMENT_URL + "/payment/create",payment,CommonResult.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id){

        return template.getForObject(PAYMENT_URL + "/payment/get/" + id,CommonResult.class);
    }

    @GetMapping("/consumer/payment/lb")
    public String getPaymentLB(){
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PROVIDER-SERVICE");
        if(instances == null && instances.size() <= 0){
            return  null;
        }
        ServiceInstance instance = loadBalanced.instance(instances);
        URI uri = instance.getUri();
        return template.getForObject(uri + "/payment/lb",String.class);
    }

}
