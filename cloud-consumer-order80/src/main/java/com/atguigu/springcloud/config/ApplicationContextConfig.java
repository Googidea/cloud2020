package com.atguigu.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Auther: yanyouming
 * @Date: 2020/5/3 09:36
 * @Description:
 */
@Configuration
public class ApplicationContextConfig {

    @Bean
    @LoadBalanced //@loadBalanced赋予负载均衡功能
    public RestTemplate getRestTemplate(){

        return new RestTemplate();
    }
}
