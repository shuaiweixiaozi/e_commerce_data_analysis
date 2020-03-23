package com.youfan.analy.hongbao;

import com.youfan.analyEntity.hongbao.HongbaoanalyEntity;
import com.youfan.analyEntity.tuangou.TuanGouanalyEntity;
import com.youfan.utils.HbaseUtil2;
import org.apache.flink.streaming.api.functions.sink.SinkFunction;

/**
 * create "userTheme","hongbao"
 */
public class HongbaoSink implements SinkFunction<HongbaoanalyEntity>{
    @Override
    public void invoke(HongbaoanalyEntity value) throws Exception {
        String tableName = "userTheme";
        String cloumnFamliy = "hongbao";
        String userid = value.getUserId();
        Long times = value.getTimes();


        String timesString = HbaseUtil2.getdata(tableName,userid,cloumnFamliy,"times");
        timesString = timesString==null?"0":timesString;
        Long preTimes = Long.valueOf(timesString);
        times += times+ preTimes;
        HbaseUtil2.putdata(tableName,userid,cloumnFamliy,"times",times+"");
    }
}
