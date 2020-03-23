package com.youfan.analy.hongbao;

import com.youfan.analyEntity.conpus.ConpusanalyEntity;
import com.youfan.analyEntity.hongbao.HongbaoanalyEntity;
import com.youfan.jiaoyi.Orderinfo;
import com.youfan.utils.RedisUtils;
import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.util.Collector;

public class HongbaoMap implements FlatMapFunction<String, HongbaoanalyEntity> {
    private final  static String conpusUserTop = "conpusUserTop";
    @Override
    public void flatMap(String s, Collector<HongbaoanalyEntity> collector) throws Exception {
        Orderinfo orderinfo = new Orderinfo();
        String[] splitArrays = s.split(",");
        orderinfo.setId(splitArrays[0]==null?null:Integer.valueOf(splitArrays[0]));
        orderinfo.setUserId(splitArrays[1]==null?null:Integer.valueOf(splitArrays[1]));
        orderinfo.setProductId(splitArrays[2]==null?null:Integer.valueOf(splitArrays[2]));
        orderinfo.setShopId(splitArrays[3]==null?null:Integer.valueOf(splitArrays[3]));
        orderinfo.setMerchartId(splitArrays[4]==null?null:Integer.valueOf(splitArrays[4]));
        orderinfo.setOrderAmount(splitArrays[5]==null?null:Double.valueOf(splitArrays[5]));
        orderinfo.setPayAmount(splitArrays[6]==null?null:Double.valueOf(splitArrays[6]));
        orderinfo.setCreateTime(splitArrays[7]==null?null:String.valueOf(splitArrays[7]));
        orderinfo.setPayType(splitArrays[8]==null?null:Integer.valueOf(splitArrays[8]));
        orderinfo.setPayTime(splitArrays[9]==null?null:String.valueOf(splitArrays[9]));
        orderinfo.setStatus(splitArrays[10]==null?null:Integer.valueOf(splitArrays[10]));
        orderinfo.setNumber(splitArrays[11]==null?null:Integer.valueOf(splitArrays[11]));
        orderinfo.setHongbaoId(splitArrays[12]==null?null:Integer.valueOf(splitArrays[12]));
        orderinfo.setHongbaoAmount(splitArrays[13]==null?null:Double.valueOf(splitArrays[13]));
        orderinfo.setConpusId(splitArrays[14]==null?null:Integer.valueOf(splitArrays[14]));
        orderinfo.setConpusAmount(splitArrays[15]==null?null:Double.valueOf(splitArrays[15]));
        orderinfo.setHuodongId(splitArrays[16]==null?null:Integer.valueOf(splitArrays[16]));
        orderinfo.setMiaoshaId(splitArrays[17]==null?null:Integer.valueOf(splitArrays[17]));
        orderinfo.setTuangouId(splitArrays[18]==null?null:Integer.valueOf(splitArrays[18]));


        Integer hongbaoId = orderinfo.getHongbaoId();
        Integer status = orderinfo.getStatus();
        Integer userId = orderinfo.getUserId();
        HongbaoanalyEntity hongbaoanalyEntity = new HongbaoanalyEntity();
        hongbaoanalyEntity.setUserId(userId+"");
        hongbaoanalyEntity.setTimes(0L);
        //private Integer status;// '0未支付 1 已支付 2 已退款 3 未支付已失效',
        if(hongbaoId!=null&&(status==1||status == 2)){
            hongbaoanalyEntity.setTimes(1L);
            RedisUtils.incrScoreData(conpusUserTop,1,userId+"");
        }

        collector.collect(hongbaoanalyEntity);
    }
}
