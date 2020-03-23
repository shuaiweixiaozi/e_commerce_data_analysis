package com.youfan.analy.tuangou;

import com.youfan.analyEntity.tuangou.TuanGouanalyEntity;
import com.youfan.jiaoyi.Orderinfo;
import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.common.functions.ReduceFunction;
import org.apache.flink.util.Collector;

public class TuanGouReduce implements ReduceFunction<TuanGouanalyEntity>{
    @Override
    public TuanGouanalyEntity reduce(TuanGouanalyEntity tuanGouanalyEntity, TuanGouanalyEntity t1) throws Exception {
        String userid =  tuanGouanalyEntity.getUserId();
        Long times1 = tuanGouanalyEntity.getTimes();
        Integer tuangouNum = tuanGouanalyEntity.getTuangouNum();
        String tuangouName = tuanGouanalyEntity.getTuangouName();

        Long Times2 = t1.getTimes();
        Integer tuangouNum2 = t1.getTuangouNum();
        String tuangouName2 = t1.getTuangouName();


        TuanGouanalyEntity tuanGouanalyEntity1 = new TuanGouanalyEntity();
        tuanGouanalyEntity1.setUserId(userid);
        tuanGouanalyEntity1.setTimes(times1+Times2);
        tuanGouanalyEntity1.setTuangouName(tuangouName);
        tuanGouanalyEntity1.setTuangouNum(tuangouNum);

        if(tuangouNum2>tuangouNum){
            tuanGouanalyEntity1.setTuangouName(tuangouName2);
            tuanGouanalyEntity1.setTuangouNum(tuangouNum2);
        }
        return tuanGouanalyEntity1;
    }
}
