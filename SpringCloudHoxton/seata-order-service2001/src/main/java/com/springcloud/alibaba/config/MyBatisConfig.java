package com.springcloud.alibaba.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author lizz
 * @date 2020/4/1 16:57
 */
@Configuration
@MapperScan("com.springcloud.alibaba.dao")
public class MyBatisConfig {
}
