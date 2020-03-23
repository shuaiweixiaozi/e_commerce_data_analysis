package com.youfan.analy.prouduct;

import com.alibaba.fastjson.JSONObject;
import com.youfan.analyEntity.productscan.ProductanalyEntity;
import com.youfan.jiaoyi.Orderinfo;
import com.youfan.utils.RedisUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.util.Collector;

public class ProductScanMap implements FlatMapFunction<String, ProductanalyEntity> {

    @Override
    public void flatMap(String s, Collector<ProductanalyEntity> collector) throws Exception {
        JSONObject jsonObject = JSONObject.parseObject(s);
        String productId = jsonObject.getString("productId");
        String userId = jsonObject.getString("userId");
        if(StringUtils.isNotBlank(productId)){
            ProductanalyEntity productanalyEntity = new ProductanalyEntity();
            productanalyEntity.setUserId(userId);
            productanalyEntity.setProductId(productId);
            productanalyEntity.setGroupField(userId+"=="+productId);
            productanalyEntity.setTimes(1L);
            collector.collect(productanalyEntity);
        }

        

    }
}
