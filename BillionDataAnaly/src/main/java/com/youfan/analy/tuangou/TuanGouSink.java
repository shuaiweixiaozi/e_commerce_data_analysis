package com.youfan.analy.tuangou;

import com.youfan.analyEntity.tuangou.TuanGouanalyEntity;
import com.youfan.utils.HbaseUtil2;
import org.apache.flink.streaming.api.functions.sink.SinkFunction;

/**
 * create "userTheme","tuangou"
 */
public class TuanGouSink implements SinkFunction<TuanGouanalyEntity>{
    @Override
    public void invoke(TuanGouanalyEntity value) throws Exception {
        String tableName = "userTheme";
        String cloumnFamliy = "tuangou";
        String userid = value.getUserId();
        Long times = value.getTimes();


        String timesString = HbaseUtil2.getdata(tableName,userid,cloumnFamliy,"times");
        timesString = timesString==null?"0":timesString;
        Long preTimes = Long.valueOf(timesString);
        times += times+ preTimes;
        HbaseUtil2.putdata(tableName,userid,cloumnFamliy,"times",times+"");


        /**
         * 最大的团购成交
         */

        String tuangouName = value.getTuangouName();
        Integer tuangouNum = value.getTuangouNum();
        String tuangouNumString = HbaseUtil2.getdata(tableName,userid,cloumnFamliy,"tuangouNum");
        tuangouNumString = tuangouNumString==null?"0":tuangouNumString;
        Long pretuangouNum = Long.valueOf(tuangouNumString);
        if(tuangouNum>pretuangouNum){
            HbaseUtil2.putdata(tableName,userid,cloumnFamliy,"tuangouNum",tuangouNum+"");
            HbaseUtil2.putdata(tableName,userid,cloumnFamliy,"tuangouName",tuangouName);
        }

    }
}
