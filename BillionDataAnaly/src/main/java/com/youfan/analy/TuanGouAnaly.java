package com.youfan.analy;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.youfan.analy.tuangou.TuanGouMap;
import com.youfan.analy.tuangou.TuanGouReduce;
import com.youfan.analy.tuangou.TuanGouSink;
import com.youfan.analyEntity.tuangou.TuanGouanalyEntity;
import com.youfan.utils.TransferUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.flink.api.common.functions.FilterFunction;
import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.api.common.serialization.SimpleStringSchema;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.windowing.time.Time;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaProducer;

import java.util.Properties;

public class TuanGouAnaly {
    private final static String sourceTopic = "orderinfo";
    public static void main(String[] args) throws Exception {
        final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        Properties properties = new Properties();
        properties.setProperty("bootstrap.servers", "192.168.159.131:9092");
        properties.setProperty("group.id", "youfan");
        //构建FlinkKafkaConsumer
        FlinkKafkaConsumer<String> myConsumer = new FlinkKafkaConsumer<String>(sourceTopic, new SimpleStringSchema(), properties);
        //指定偏移量
        myConsumer.setStartFromLatest();
        DataStream<String> stream = env
                .addSource(myConsumer);
        env.enableCheckpointing(5000);
        DataStream<TuanGouanalyEntity> map = stream.flatMap(new TuanGouMap());
        DataStream<TuanGouanalyEntity> tuanGouanalyreduce = map.keyBy("userId").timeWindowAll(Time.seconds(2)).reduce(new TuanGouReduce());
        tuanGouanalyreduce.addSink(new TuanGouSink());

        env.execute("TuanGouAnaly");
    }
}
