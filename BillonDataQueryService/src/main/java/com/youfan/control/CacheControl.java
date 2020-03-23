package com.youfan.control;

import com.youfan.service.CacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("cache")
public class CacheControl {
    @Autowired
    private CacheService cacheService;

    @RequestMapping("updateusername")
    public String updateUserName(String userId){
        return cacheService.updateUserName(userId);
    }

    @RequestMapping("updateusername")
    public String updateProductName(String productId){
        return cacheService.updateProductName(productId);
    }

    @RequestMapping("updateusername")
    public String updateProductTypeName(String productTypeId){
        return cacheService.updateProductTypeName(productTypeId);
    }

}
