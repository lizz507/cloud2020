package com.springcloud.alibaba.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author lizz
 * @date 2020/4/2 9:52
 */
@MapperScan("com.springcloud.alibaba.dao")
@Configuration
public class MyBatisConfig {
}
