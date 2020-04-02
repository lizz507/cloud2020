package com.springcloud.alibaba.dao;

import com.springcloud.alibaba.domain.Storage;
import org.apache.ibatis.annotations.Param;

/**
 * @author lizz
 * @date 2020/4/1 18:06
 */
public interface StorageDao {

    Storage query(@Param("productId")Long productId);

    void update(@Param("productId")Long productId,@Param("count")Integer count);
}
