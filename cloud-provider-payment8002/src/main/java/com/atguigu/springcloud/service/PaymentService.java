package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @Auther: yanyouming
 * @Date: 2020/5/2 21:40
 * @Description:
 */
public interface PaymentService {
    public int create(Payment payment);

    public Payment getPaymentByid(Long id);
}
