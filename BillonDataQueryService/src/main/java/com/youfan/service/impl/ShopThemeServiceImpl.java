package com.youfan.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.youfan.service.ShopThemeService;
import com.youfan.utils.GreenplumUtils;
import com.youfan.viewResult.KeyValueEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ShopThemeServiceImpl implements ShopThemeService {

    @Override
    public List<KeyValueEntity> tuangoubytime(String startTime, String endTime) {
        List<Map<String,String>> list = GreenplumUtils.getShopByTuangouAnaly(startTime,endTime);
        List<KeyValueEntity> keyvalueEntitylist =new ArrayList<KeyValueEntity>();
        for(Map<String,String> map:list){
            KeyValueEntity keyvalueEntity = new KeyValueEntity();
            keyvalueEntity.setKey(map.get("shopname"));
            keyvalueEntity.setValue(map.get("tuangounumber"));
            keyvalueEntitylist.add(keyvalueEntity);
        }

        return  keyvalueEntitylist;
    }

    @Override
    public List<KeyValueEntity> productTypebytime(String startTime, String endTime) {
        List<Map<String,String>> list = GreenplumUtils.getShopByProductTypeAnaly(startTime,endTime);
        List<KeyValueEntity> keyvalueEntitylist =new ArrayList<KeyValueEntity>();
        for(Map<String,String> map:list){
            KeyValueEntity keyvalueEntity = new KeyValueEntity();
            keyvalueEntity.setKey(map.get("shopname"));
            keyvalueEntity.setValue(map.get("producttypeNum"));
            keyvalueEntitylist.add(keyvalueEntity);
        }

        return  keyvalueEntitylist;
    }

    @Override
    public List<KeyValueEntity> hongbaobytime(String startTime, String endTime) {
        List<Map<String,String>> list = GreenplumUtils.getShopByHongBaoAnaly(startTime,endTime);
        List<KeyValueEntity> keyvalueEntitylist =new ArrayList<KeyValueEntity>();
        for(Map<String,String> map:list){
            KeyValueEntity keyvalueEntity = new KeyValueEntity();
            keyvalueEntity.setKey(map.get("shopname"));
            keyvalueEntity.setValue(map.get("hongbaonubmer"));
            keyvalueEntitylist.add(keyvalueEntity);
        }

        return  keyvalueEntitylist;
    }

    @Override
    public List<KeyValueEntity> cjbytime(String startTime, String endTime) {
        List<Map<String,String>> list = GreenplumUtils.getShopByCJAnaly(startTime,endTime);
        List<KeyValueEntity> keyvalueEntitylist =new ArrayList<KeyValueEntity>();
        for(Map<String,String> map:list){
            KeyValueEntity keyvalueEntity = new KeyValueEntity();
            keyvalueEntity.setKey(map.get("shopname"));
            keyvalueEntity.setValue(map.get("paynumber"));
            keyvalueEntitylist.add(keyvalueEntity);
        }

        return  keyvalueEntitylist;
    }

    @Override
    public List<KeyValueEntity> userbytime(String startTime, String endTime) {
        List<Map<String,String>> list = GreenplumUtils.getShopByUserAnaly(startTime,endTime);
        List<KeyValueEntity> keyvalueEntitylist =new ArrayList<KeyValueEntity>();
        for(Map<String,String> map:list){
            KeyValueEntity keyvalueEntity = new KeyValueEntity();
            keyvalueEntity.setKey(map.get("shopname"));
            keyvalueEntity.setValue(map.get("usernumber"));
            keyvalueEntitylist.add(keyvalueEntity);
        }

        return  keyvalueEntitylist;
    }
}
