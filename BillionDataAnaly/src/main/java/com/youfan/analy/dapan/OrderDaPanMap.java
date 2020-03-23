package com.youfan.analy.dapan;

import com.youfan.analyEntity.tuangou.TuanGouanalyEntity;
import com.youfan.dapan.OrderDapan;
import com.youfan.jiaoyi.Orderinfo;
import com.youfan.utils.HbaseUtil2;
import com.youfan.utils.MysqlUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.util.Collector;

public class OrderDaPanMap implements FlatMapFunction<String, OrderDapan> {

    @Override
    public void flatMap(String s, Collector<OrderDapan> collector) throws Exception {
        Orderinfo orderinfo = new Orderinfo();
        String[] splitArrays = s.split(",");
        orderinfo.setId(splitArrays[0]==null?null:Integer.valueOf(splitArrays[0]));
        orderinfo.setUserId(splitArrays[1]==null?null:Integer.valueOf(splitArrays[1]));
        orderinfo.setProductId(splitArrays[2]==null?null:Integer.valueOf(splitArrays[2]));
        orderinfo.setPayAmount(splitArrays[6]==null?null:Double.valueOf(splitArrays[6]));
        orderinfo.setPayType(splitArrays[8]==null?null:Integer.valueOf(splitArrays[8]));
        orderinfo.setPayTime(splitArrays[9]==null?null:String.valueOf(splitArrays[9]));
        String productTypeid = HbaseUtil2.getdata("productinfo",orderinfo.getProductId()+"","data","productTypeid");
        String productTypeName = HbaseUtil2.getdata("producttypeinfo",productTypeid,"data","productTypeName");
        OrderDapan orderDapan = new OrderDapan();
        if(StringUtils.isNotBlank(orderinfo.getPayTime())){
            orderDapan.setPayAmount(orderinfo.getPayAmount());
            orderDapan.setPayTime(orderinfo.getPayTime());
            orderDapan.setPayType(orderinfo.getPayType()+"");
            orderDapan.setProductTypeid(productTypeid);
            orderDapan.setProductTypeName(productTypeName);
            orderDapan.setUserId(orderinfo.getUserId()+"");
            boolean exits = MysqlUtils.exitsDapanInfo(orderDapan);
            if(exits){
                MysqlUtils.updateDapanInfo(orderDapan);
            }else {
                MysqlUtils.insertDapanInfo(orderDapan);
            }
        }

        collector.collect(orderDapan);
    }
}
