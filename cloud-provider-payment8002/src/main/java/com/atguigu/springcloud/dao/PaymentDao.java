package com.atguigu.springcloud.dao;

import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Auther: yanyouming
 * @Date: 2020/5/2 21:18
 * @Description:
 */
@Mapper
public interface PaymentDao {
    public int create(Payment payment);

    public Payment getPaymentByid(@Param("id") Long id);
}
