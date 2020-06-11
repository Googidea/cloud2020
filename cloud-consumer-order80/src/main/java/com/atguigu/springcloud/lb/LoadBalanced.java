package com.atguigu.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @Auther: yanyouming
 * @Date: 2020/5/20 22:24
 * @Description:
 */
public interface LoadBalanced
{
    ServiceInstance instance(List<ServiceInstance> serviceInstances);
}
