package com.youfan.analy.device;

import com.youfan.analyEntity.device.DeviceanalyEntity;
import com.youfan.analyEntity.tuangou.TuanGouanalyEntity;
import com.youfan.utils.HbaseUtil2;
import org.apache.commons.lang3.StringUtils;
import org.apache.flink.streaming.api.functions.sink.SinkFunction;

/**
 * create "userTheme","device"
 */
public class DeviceSink implements SinkFunction<DeviceanalyEntity>{
    @Override
    public void invoke(DeviceanalyEntity value) throws Exception {
        String tableName = "userTheme";
        String cloumnFamliy = "device";

        String groupField = value.getGroupField();
        String[] temp = groupField.split("==");
        String userId = temp[0];
        String type = temp[1];
        Long times = value.getTimes();

        String deviceTimes = HbaseUtil2.getdata(tableName,groupField,cloumnFamliy,"times");
        if(StringUtils.isBlank(deviceTimes)){
            HbaseUtil2.putdata(tableName,groupField,cloumnFamliy,"times",times+"");
        }else{
            HbaseUtil2.putdata(tableName,groupField,cloumnFamliy,"times",(Long.valueOf(deviceTimes)+times)+"");
        }
        String deviceTypenum = HbaseUtil2.getdata(tableName,groupField,cloumnFamliy,"times");
        String maxdeviceTypenum = HbaseUtil2.getdata(tableName,userId,cloumnFamliy,"maxtimes");
        if(StringUtils.isBlank(maxdeviceTypenum)||Long.valueOf(deviceTypenum)>Long.valueOf(maxdeviceTypenum)){

            HbaseUtil2.putdata(tableName,groupField,cloumnFamliy,"maxtimes",maxdeviceTypenum);
            HbaseUtil2.putdata(tableName,groupField,cloumnFamliy,"maxdeviceType",type);
        }
    }
}
