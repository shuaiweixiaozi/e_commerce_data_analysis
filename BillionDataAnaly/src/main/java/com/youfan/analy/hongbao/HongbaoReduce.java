package com.youfan.analy.hongbao;

import com.youfan.analyEntity.conpus.ConpusanalyEntity;
import com.youfan.analyEntity.hongbao.HongbaoanalyEntity;
import org.apache.flink.api.common.functions.ReduceFunction;

public class HongbaoReduce implements ReduceFunction<HongbaoanalyEntity>{
    @Override
    public HongbaoanalyEntity reduce(HongbaoanalyEntity hongbaoanalyEntity, HongbaoanalyEntity t1) throws Exception {
        String userid =  hongbaoanalyEntity.getUserId();
        Long times1 = hongbaoanalyEntity.getTimes();

        Long Times2 = t1.getTimes();


        HongbaoanalyEntity hongbaoanalyEntity1 = new HongbaoanalyEntity();
        hongbaoanalyEntity1.setUserId(userid);
        hongbaoanalyEntity1.setTimes(times1+Times2);
        return hongbaoanalyEntity1;
    }
}
