package com.springcloud.alibaba.dao;

import com.springcloud.alibaba.domain.Account;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
 * @author lizz
 * @date 2020/4/2 9:52
 */
public interface AccountDao {

    Account query(@Param("userId") Long userId);

    void update(@Param("userId") Long userId, @Param("money")BigDecimal money);
}
