package com.youfan.analy.conpus;

import com.youfan.analyEntity.conpus.ConpusanalyEntity;
import com.youfan.analyEntity.tuangou.TuanGouanalyEntity;
import com.youfan.utils.HbaseUtil2;
import org.apache.flink.streaming.api.functions.sink.SinkFunction;

/**
 * create "userTheme","conpus"
 */
public class ConpusSink implements SinkFunction<ConpusanalyEntity>{
    @Override
    public void invoke(ConpusanalyEntity value) throws Exception {
        String tableName = "userTheme";
        String cloumnFamliy = "conpus";
        String userid = value.getUserId();
        Long times = value.getTimes();


        String timesString = HbaseUtil2.getdata(tableName,userid,cloumnFamliy,"times");
        timesString = timesString==null?"0":timesString;
        Long preTimes = Long.valueOf(timesString);
        times += times+ preTimes;
        HbaseUtil2.putdata(tableName,userid,cloumnFamliy,"times",times+"");
    }
}
