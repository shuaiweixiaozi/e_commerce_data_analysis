package com.youfan.transfer;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.youfan.product.Shopinfo;
import com.youfan.utils.GreenplumUtils;
import com.youfan.utils.TransferUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.flink.api.common.functions.FilterFunction;
import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.api.common.serialization.SimpleStringSchema;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaProducer;

import java.util.Properties;

public class ShopinfoTransferData {
    private final static String splitString = "==";
    private final static String targetTopic = "shopinfo";
    public static void main(String[] args) throws Exception {
        final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        Properties properties = new Properties();
        properties.setProperty("bootstrap.servers", "192.168.159.131:9092");
        properties.setProperty("group.id", "youfan");
        //构建FlinkKafkaConsumer
        FlinkKafkaConsumer<String> myConsumer = new FlinkKafkaConsumer<String>("test1", new SimpleStringSchema(), properties);
        //指定偏移量
        myConsumer.setStartFromLatest();
        DataStream<String> stream = env
                .addSource(myConsumer);
        env.enableCheckpointing(5000);

        final DataStream<String> map = stream.map(new MapFunction<String,String>(){
            @Override
            public String map(String s) throws Exception {
                JSONObject jsonObject = JSONObject.parseObject(s);
                JSONArray jsonArray = jsonObject.getJSONArray("data");
                JSONObject data = jsonArray.getJSONObject(0);
                String type = jsonObject.getString("type");

                String ts = jsonObject.getString("ts");
                String table = jsonObject.getString("table");
                String reuslt = table+splitString+"";
                if("INSERT".equals(type)&&table.equals(targetTopic)){
                    String shopinfo = TransferUtil.transferData(table,data);
                    reuslt = table+splitString+shopinfo;
                    String[] splitArrays = shopinfo.split(",");
                    Shopinfo shopinfo1 = new Shopinfo();
                    shopinfo1.setId(splitArrays[0]==null?null:Integer.valueOf(splitArrays[0]));
                    shopinfo1.setShopname(splitArrays[1]==null?null:String.valueOf(splitArrays[1]));
                    shopinfo1.setMerchartId(splitArrays[2]==null?null:Integer.valueOf(splitArrays[2]));
                    shopinfo1.setShopdesrc(splitArrays[1]==null?null:String.valueOf(splitArrays[3]));
                    GreenplumUtils.insertShopinfo(shopinfo1);
                }
                System.out.println(type);
                System.out.println(ts);
                System.out.println(reuslt);
                return reuslt;
            }
        });
        DataStream<String> filter = map.filter(new FilterFunction<String>(){
            @Override
            public boolean filter(String s) throws Exception {
                boolean isFliter = true;
                String[] reusltarray = s.split(splitString);
                String data = reusltarray[1];
                if(StringUtils.isBlank(data)){
                    isFliter = false;
                }
                return isFliter;
            }
        });

        FlinkKafkaProducer<String> myProducer = new FlinkKafkaProducer<String>(
                "192.168.159.131:9092", targetTopic, new SimpleStringSchema());
        myProducer.setWriteTimestampToKafka(true);

        filter.addSink(myProducer);

        env.execute("ShopinfoTransferData");
    }
}
