package com.springcloud.alibaba.service.impl;

import com.springcloud.alibaba.dao.StorageDao;
import com.springcloud.alibaba.domain.Storage;
import com.springcloud.alibaba.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author lizz
 * @date 2020/4/1 18:02
 */
@Slf4j
@Service
public class StorageServiceImpl implements StorageService {

    @Resource
    private StorageDao storageDao;

    @Override
    public void decrease(Long productId, Integer count) {

        Storage storage = storageDao.query(productId);
        if(storage.getResidue() >= count)
            storageDao.update(productId,count);
        else{
            throw new RuntimeException("库存不足");
        }
    }
}
