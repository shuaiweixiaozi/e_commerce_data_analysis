package com.youfan.service;

import com.youfan.utils.HbaseUtil2;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

public interface CacheService {

    public String findUserName(String userId);

   public String findProductName(String productId);

   public String findProductTypeInfo(String productTypeId);


   public String updateUserName(String userId);

   public String updateProductName(String productId);

   public String updateProductTypeName(String productTypeId);
}
