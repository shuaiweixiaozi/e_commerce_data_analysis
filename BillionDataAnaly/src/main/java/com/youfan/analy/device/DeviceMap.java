package com.youfan.analy.device;

import com.alibaba.fastjson.JSONObject;
import com.youfan.analyEntity.conpus.ConpusanalyEntity;
import com.youfan.analyEntity.device.DeviceanalyEntity;
import com.youfan.jiaoyi.Orderinfo;
import com.youfan.utils.RedisUtils;
import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.util.Collector;

public class DeviceMap implements FlatMapFunction<String, DeviceanalyEntity> {
    @Override
    public void flatMap(String s, Collector<DeviceanalyEntity> collector) throws Exception {
        JSONObject jsonObject = JSONObject.parseObject(s);
        String userId = jsonObject.getString("userId");
        String logType = jsonObject.getString("logType");
        DeviceanalyEntity deviceanalyEntity = new DeviceanalyEntity();
        deviceanalyEntity.setDeviceType(logType);
        deviceanalyEntity.setTimes(1L);
        deviceanalyEntity.setUserId(userId);
        deviceanalyEntity.setGroupField(userId+"=="+logType);

        collector.collect(deviceanalyEntity);
    }
}
