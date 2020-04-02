package com.springcloud.alibaba.service;

import java.math.BigDecimal;

/**
 * @author lizz
 * @date 2020/4/2 9:54
 */
public interface AccountService {

    void decrease(Long userId, BigDecimal money);
}
