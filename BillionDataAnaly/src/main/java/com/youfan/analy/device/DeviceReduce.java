package com.youfan.analy.device;

import com.youfan.analyEntity.conpus.ConpusanalyEntity;
import com.youfan.analyEntity.device.DeviceanalyEntity;
import org.apache.flink.api.common.functions.ReduceFunction;

public class DeviceReduce implements ReduceFunction<DeviceanalyEntity>{
    @Override
    public DeviceanalyEntity reduce(DeviceanalyEntity deviceanalyEntity, DeviceanalyEntity t1) throws Exception {
        String groupField =  deviceanalyEntity.getGroupField();
        Long times1 = deviceanalyEntity.getTimes();

        Long Times2 = t1.getTimes();


        DeviceanalyEntity deviceanalyEntity1 = new DeviceanalyEntity();
        deviceanalyEntity1.setGroupField(groupField);
        deviceanalyEntity1.setTimes(times1+Times2);
        return deviceanalyEntity1;
    }
}
