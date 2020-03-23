package com.youfan.service.impl;

import com.youfan.service.CacheService;
import com.youfan.utils.HbaseUtil2;
import com.youfan.viewResult.KeyValueEntity;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class CacheServiceImpl implements CacheService {
    /**
     * value属性表示使用哪个缓存策略，缓存策略在ehcache.xml
     */
    public static final String CACHE_NAME = "youfan";

    @Override
    @Cacheable(value = CACHE_NAME,key = "'userinfo'+#userId")
    public String findUserName(String userId){
        String userName = null;
        try {
            userName = HbaseUtil2.getdata("userinfo",userId,"data","name");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userName;
    }

    @Override
    @Cacheable(value = CACHE_NAME,key = "'productinfo'+#productId")
    public String findProductName(String productId){
        String productName = null;
        try {
            productName = HbaseUtil2.getdata("productinfo",productId+"","data","productName");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return productName;
    }

    @Override
    @Cacheable(value = CACHE_NAME,key = "'producttypeinfo'+#productTypeId")
    public String findProductTypeInfo(String productTypeId){
        String productTypeName = null;
        try {
            productTypeName = HbaseUtil2.getdata("producttypeinfo",productTypeId,"data","productTypeName");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return productTypeName;
    }

    @Override
    @CachePut(value = CACHE_NAME,key = "'userinfo'+#userId")
    public String updateUserName(String userId){
        String userName = null;
        try {
            userName = HbaseUtil2.getdata("userinfo",userId,"data","name");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userName;
    }

    @Override
    @CachePut(value = CACHE_NAME,key = "'productinfo'+#productId")
    public String updateProductName(String productId){
        String productName = null;
        try {
            productName = HbaseUtil2.getdata("productinfo",productId+"","data","productName");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return productName;
    }

    @Override
    @CachePut(value = CACHE_NAME,key = "'producttypeinfo'+#productTypeId")
    public String updateProductTypeName(String productTypeId){
        String productTypeName = null;
        try {
            productTypeName = HbaseUtil2.getdata("producttypeinfo",productTypeId,"data","productTypeName");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return productTypeName;
    }
   
}