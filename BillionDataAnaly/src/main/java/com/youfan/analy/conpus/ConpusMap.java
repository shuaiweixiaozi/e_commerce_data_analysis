package com.youfan.analy.conpus;

import com.youfan.analyEntity.conpus.ConpusanalyEntity;
import com.youfan.analyEntity.tuangou.TuanGouanalyEntity;
import com.youfan.jiaoyi.Orderinfo;
import com.youfan.utils.HbaseUtil2;
import com.youfan.utils.RedisUtils;
import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.util.Collector;

public class ConpusMap implements FlatMapFunction<String, ConpusanalyEntity> {
    private final  static String conpusUserTop = "conpusUserTop";
    @Override
    public void flatMap(String s, Collector<ConpusanalyEntity> collector) throws Exception {
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


        Integer coupusId = orderinfo.getConpusId();
        Integer status = orderinfo.getStatus();
        Integer userId = orderinfo.getUserId();
        ConpusanalyEntity conpusanalyEntity = new ConpusanalyEntity();
        conpusanalyEntity.setUserId(userId+"");
        conpusanalyEntity.setTimes(0L);
        //private Integer status;// '0未支付 1 已支付 2 已退款 3 未支付已失效',
        if(coupusId!=null&&(status==1||status == 2)){
            conpusanalyEntity.setTimes(1L);
            RedisUtils.incrScoreData(conpusUserTop,1,userId+"");
        }

        collector.collect(conpusanalyEntity);
    }
}
