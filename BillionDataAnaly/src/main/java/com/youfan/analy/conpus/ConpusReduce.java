package com.youfan.analy.conpus;

import com.youfan.analyEntity.conpus.ConpusanalyEntity;
import com.youfan.analyEntity.tuangou.TuanGouanalyEntity;
import org.apache.flink.api.common.functions.ReduceFunction;

public class ConpusReduce implements ReduceFunction<ConpusanalyEntity>{
    @Override
    public ConpusanalyEntity reduce(ConpusanalyEntity conpusanalyEntity, ConpusanalyEntity t1) throws Exception {
        String userid =  conpusanalyEntity.getUserId();
        Long times1 = conpusanalyEntity.getTimes();

        Long Times2 = t1.getTimes();


        ConpusanalyEntity conpusanalyEntity1 = new ConpusanalyEntity();
        conpusanalyEntity1.setUserId(userid);
        conpusanalyEntity1.setTimes(times1+Times2);
        return conpusanalyEntity1;
    }
}
