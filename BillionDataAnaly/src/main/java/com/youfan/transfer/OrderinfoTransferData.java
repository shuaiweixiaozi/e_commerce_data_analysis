package com.youfan.transfer;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.youfan.jiaoyi.Orderinfo;
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

public class OrderinfoTransferData {
    private final static String splitString = "==";
    private final static String targetTopic = "orderinfo";
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
                    String orderinfoString = TransferUtil.transferData(table,data);
                    reuslt = table+splitString+orderinfoString;


                    Orderinfo orderinfo = new Orderinfo();
                    String[] splitArrays = orderinfoString.split(",");
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
                    GreenplumUtils.insertOrderInfo(orderinfo);
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

        env.execute("OrderinfoTransferData");
    }
}
