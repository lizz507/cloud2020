package com.springcloud.alibaba.dao;

import com.springcloud.alibaba.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author lizz
 * @date 2020/4/1 14:22
 */
@Mapper
public interface OrderDao {

    //创建订单
    void create(@Param("order") Order order);

    //更新订单
    void update(@Param("userId")Long userId,@Param("status")Integer status);
}
