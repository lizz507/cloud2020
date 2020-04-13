package com.springcloud.alibaba.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author lizz
 * @date 2020/4/1 14:18
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    private Long id;
    private Long userId;
    private Long productId;
    private Integer count;
    private BigDecimal money;
    private Integer status; //0 创建中   1 已完成


    public static void main(String[] args) {
        System.out.println("这是基准时间");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(new Date(1288834974657L)));


        System.out.println(-1L << 5L);
        System.out.println(-1L ^ (-1L << 5L));
    }
}
