package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Auther: yanyouming
 * @Date: 2020/5/2 20:52
 * @Description:
 */
@SpringBootApplication
@EnableEurekaClient
public class Payment8002 {

    public static void main(String[] args) {
        SpringApplication.run(Payment8002.class,args);
    }
}
