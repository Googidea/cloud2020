package com.atguigu.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Auther: yanyouming
 * @Date: 2020/5/20 22:27
 * @Description:
 */
@Component
public class MyLB implements LoadBalanced {

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public final int getAndIncrement(){
        int curent;
        int next;
        do {
            curent = this.atomicInteger.get();
            next = curent >= Integer.MAX_VALUE ?0:curent +1;
        }while (!this.atomicInteger.compareAndSet(curent,next));
        System.out.println("*******第几次访问次数next****:"+next);
        return  next;
    }

    @Override
    public ServiceInstance instance(List<ServiceInstance> serviceInstances) {
        int index = getAndIncrement() % serviceInstances.size();
        return serviceInstances.get(index);
    }
}
