package com.youfan.service.impl;

import com.youfan.service.CacheService;
import com.youfan.service.TimingTopService;
import com.youfan.utils.HbaseUtil2;
import com.youfan.utils.RedisUtils;
import com.youfan.viewResult.KeyValueEntity;
import com.youfan.viewResult.ViewResultAnaly;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Tuple;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class TimingTopServiceImpl implements TimingTopService {

    @Autowired
    private CacheService cacheService;

    @Override
    public List<KeyValueEntity> tuangouuserstop() {
        List<KeyValueEntity> keyvalueEntityList =new ArrayList<KeyValueEntity>();
        Set<Tuple> setByscore = RedisUtils.getTopDataByScore("tuanGouUserTop",50);
        for(Tuple tuple :setByscore){
            String element = tuple.getElement();
            try {
                element = cacheService.findUserName(element);
            } catch (Exception e) {
                e.printStackTrace();
            }
            double score = tuple.getScore();
            KeyValueEntity timingEntity = new KeyValueEntity();
            timingEntity.setKey(element);
            timingEntity.setValue(score+"");
            keyvalueEntityList.add(timingEntity);
        }
        return keyvalueEntityList;
    }

    @Override
    public List<KeyValueEntity> producttypetop() {
        List<KeyValueEntity> keyvalueEntityList =new ArrayList<KeyValueEntity>();
        Set<Tuple> setByscore = RedisUtils.getTopDataByScore("productTypeTop",50);
        for(Tuple tuple :setByscore){
            String element = tuple.getElement();
            try {
                element = cacheService.findProductTypeInfo(element);
            } catch (Exception e) {
                e.printStackTrace();
            }
            double score = tuple.getScore();
            KeyValueEntity timingEntity = new KeyValueEntity();
            timingEntity.setKey(element);
            timingEntity.setValue(score+"");
            keyvalueEntityList.add(timingEntity);
        }
        return keyvalueEntityList;
    }

    @Override
    public List<KeyValueEntity> producttop() {
        List<KeyValueEntity> keyvalueEntityList =new ArrayList<KeyValueEntity>();
        Set<Tuple> setByscore = RedisUtils.getTopDataByScore("productTop",50);
        for(Tuple tuple :setByscore){
            String element = tuple.getElement();
            try {
                element = cacheService.findProductName(element);
            } catch (Exception e) {
                e.printStackTrace();
            }
            double score = tuple.getScore();
            KeyValueEntity timingEntity = new KeyValueEntity();
            timingEntity.setKey(element);
            timingEntity.setValue(score+"");
            keyvalueEntityList.add(timingEntity);
        }
        return keyvalueEntityList;
    }

    @Override
    public List<KeyValueEntity> conpususerstop() {
        List<KeyValueEntity> keyvalueEntityList =new ArrayList<KeyValueEntity>();
        Set<Tuple> setByscore = RedisUtils.getTopDataByScore("conpusUserTop",50);
        for(Tuple tuple :setByscore){
            String element = tuple.getElement();
            try {
                element = cacheService.findUserName(element);
            } catch (Exception e) {
                e.printStackTrace();
            }
            double score = tuple.getScore();
            KeyValueEntity timingEntity = new KeyValueEntity();
            timingEntity.setKey(element);
            timingEntity.setValue(score+"");
            keyvalueEntityList.add(timingEntity);
        }
        return keyvalueEntityList;
    }
}
