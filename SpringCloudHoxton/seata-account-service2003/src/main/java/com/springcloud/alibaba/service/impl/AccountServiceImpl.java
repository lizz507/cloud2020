package com.springcloud.alibaba.service.impl;

import com.springcloud.alibaba.dao.AccountDao;
import com.springcloud.alibaba.domain.Account;
import com.springcloud.alibaba.service.AccountService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @author lizz
 * @date 2020/4/2 9:55
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Resource
    private AccountDao accountDao;

    @Override
    public void decrease(Long userId, BigDecimal money) {
        Account account = accountDao.query(userId);
        if(account.getResidue().compareTo(money) < 0)
            throw new RuntimeException("账户余额不足，扣款失败");
        accountDao.update(userId,money);
    }
}
