package com.youfan.analy.gaoFuFei;

import com.youfan.dapan.OrderDapan;
import com.youfan.gaofufei.OrderGaoFuFei;
import com.youfan.jiaoyi.Orderinfo;
import com.youfan.utils.HbaseUtil2;
import com.youfan.utils.MysqlUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.util.Collector;

public class OrderGaoFuFeiMap implements FlatMapFunction<String, OrderGaoFuFei> {

    @Override
    public void flatMap(String s, Collector<OrderGaoFuFei> collector) throws Exception {
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
        OrderGaoFuFei orderGaoFuFei = new OrderGaoFuFei();
        if(StringUtils.isNotBlank(orderinfo.getPayTime())&&orderinfo.getPayAmount()>1000){
            orderGaoFuFei.setPayAmount(orderinfo.getPayAmount());
            orderGaoFuFei.setPayTime(orderinfo.getPayTime());
            orderGaoFuFei.setPayType(orderinfo.getPayType()+"");
            orderGaoFuFei.setProductTypeid(productTypeid);
            orderGaoFuFei.setProductTypeName(productTypeName);
            orderGaoFuFei.setUserId(orderinfo.getUserId()+"");
            orderGaoFuFei.setPaycount(1);
            boolean exits = MysqlUtils.exitsGaoFuFei(orderGaoFuFei);
            if(exits){
                MysqlUtils.updateGaoFuFeiInfo(orderGaoFuFei);
            }else {
                MysqlUtils.insertGaoFuFeiInfo(orderGaoFuFei);
            }
        }

        collector.collect(orderGaoFuFei);
    }
}
