package com.youfan.transfer;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.youfan.utils.HbaseUtil2;
import com.youfan.utils.TransferUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.flink.api.common.functions.FilterFunction;
import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.api.common.serialization.SimpleStringSchema;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaProducer;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class UserinfoTransferData {
    private final static String splitString = "==";
    private final static String targetTopic = "userinfo";
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
                    String transferString = TransferUtil.transferData(table,data);
                    reuslt = table+splitString+transferString;
                    //create "userinfo","data"
                    String[] splitArrays = transferString.split(",");
                    Integer id = splitArrays[0]==null?null:Integer.valueOf(splitArrays[0]);
                    String name = splitArrays[1]==null?null:String.valueOf(splitArrays[1]);
                    String area = splitArrays[2]==null?null:String.valueOf(splitArrays[2]);
                    Integer age = splitArrays[3]==null?null:Integer.valueOf(splitArrays[3]);
                    String email = splitArrays[4]==null?null:String.valueOf(splitArrays[4]);
                    String birthday = splitArrays[5]==null?null:String.valueOf(splitArrays[5]);
                    String account = splitArrays[6]==null?null:String.valueOf(splitArrays[6]);
                    String  telphone = splitArrays[7]==null?null:String.valueOf(splitArrays[7]);
                    Map<String,String> datamap = new HashMap<String,String>();
                    datamap.put("id",id+"");
                    datamap.put("name",name);
                    datamap.put("area",area+"");
                    datamap.put("age",age+"");
                    datamap.put("email",email+"");
                    datamap.put("birthday",birthday+"");
                    datamap.put("account",account+"");
                    datamap.put("telphone",telphone+"");
                    HbaseUtil2.put("userinfo",id+"","data",datamap);
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

        env.execute("UserinfoTransferData");
    }
}
