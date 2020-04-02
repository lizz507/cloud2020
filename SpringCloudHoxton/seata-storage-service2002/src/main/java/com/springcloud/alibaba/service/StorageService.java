package com.springcloud.alibaba.service;

/**
 * @author lizz
 * @date 2020/4/1 18:01
 */
public interface StorageService {

    void decrease(Long productId,Integer count);
}
