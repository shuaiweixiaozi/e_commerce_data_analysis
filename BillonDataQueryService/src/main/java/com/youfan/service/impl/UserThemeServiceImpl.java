package com.youfan.service.impl;

import com.youfan.service.CacheService;
import com.youfan.service.UserThemeService;
import com.youfan.utils.HbaseUtil2;
import com.youfan.utils.RedisUtils;
import com.youfan.viewResult.KeyValueEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Tuple;

import java.util.*;

@Service
/**
 * create "userTheme","tuangou","conpus","hongbao","productscan","device"
 */
public class UserThemeServiceImpl implements UserThemeService {

    @Autowired
    private CacheService cacheService;

    String tableName = "userTheme";
    String tuangouCloumnFamliy = "tuangou";
    String conpusCloumnFamliy = "conpus";
    String hongbaoCloumnFamliy = "hongbao";
    String productscanCloumnFamliy = "productscan";
    String deviceCloumnFamliy = "device";

    static Map<String,String> logTypedict = new HashMap<String,String>();
    static{
        logTypedict.put("APP","app端");
        logTypedict.put("XIAOCHENXU","小程序端");
        logTypedict.put("PC","pc端");
    }

    /**
     * 团购次数
     * 最大团购名称和团购人数
     * 优惠劵次数
     * 红包次数
     * 浏览商品次数
     * 浏览最多次商品名称
     * 最常使用终端
     */
    @Override
    public List<KeyValueEntity> useranaly(String userId) {
        List<KeyValueEntity> keyvalueEntityList =new ArrayList<KeyValueEntity>();
        try {
            String tuangouantimes = HbaseUtil2.getdata(tableName,userId,tuangouCloumnFamliy,"times");
            String tuangouNum = HbaseUtil2.getdata(tableName,userId,tuangouCloumnFamliy,"tuangouNum");
            String tuangouName = HbaseUtil2.getdata(tableName,userId,tuangouCloumnFamliy,"tuangouName");
            KeyValueEntity timingEntity = new KeyValueEntity();
            timingEntity.setKey("团购次数");
            timingEntity.setValue(tuangouantimes);
            keyvalueEntityList.add(timingEntity);
            timingEntity = new KeyValueEntity();
            timingEntity.setKey("最大团购名称");
            timingEntity.setValue(tuangouName);
            keyvalueEntityList.add(timingEntity);
            timingEntity = new KeyValueEntity();
            timingEntity.setKey("最大团购人数");
            timingEntity.setValue(tuangouNum);
            keyvalueEntityList.add(timingEntity);

            String conpustimes = HbaseUtil2.getdata(tableName,userId,conpusCloumnFamliy,"times");
            timingEntity = new KeyValueEntity();
            timingEntity.setKey("优惠卷使用次数");
            timingEntity.setValue(conpustimes);
            keyvalueEntityList.add(timingEntity);

            String hongbaotimes = HbaseUtil2.getdata(tableName,userId,hongbaoCloumnFamliy,"times");
            timingEntity = new KeyValueEntity();
            timingEntity.setKey("红包使用次数");
            timingEntity.setValue(hongbaotimes);
            keyvalueEntityList.add(timingEntity);

            String productscantimes = HbaseUtil2.getdata(tableName,userId,productscanCloumnFamliy,"totaltimes");
            String maxproductId = HbaseUtil2.getdata(tableName,userId,productscanCloumnFamliy,"maxproductId");
            String maxproductName = cacheService.findProductName(maxproductId);
            timingEntity = new KeyValueEntity();
            timingEntity.setKey("浏览商品次数");
            timingEntity.setValue(productscantimes);
            keyvalueEntityList.add(timingEntity);
            timingEntity = new KeyValueEntity();
            timingEntity.setKey("浏览最多次商品名称");
            timingEntity.setValue(maxproductName);
            keyvalueEntityList.add(timingEntity);

            String maxdeviceType = HbaseUtil2.getdata(tableName,userId,deviceCloumnFamliy,"maxdeviceType");
            timingEntity = new KeyValueEntity();
            timingEntity.setKey("最常使用终端");
            timingEntity.setValue( logTypedict.get(maxdeviceType));
            keyvalueEntityList.add(timingEntity);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return keyvalueEntityList;
    }
}
