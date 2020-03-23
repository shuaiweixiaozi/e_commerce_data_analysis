package com.youfan.analy;

import com.youfan.analy.productType.ProductTypeMap;
import com.youfan.analy.tuangou.TuanGouMap;
import com.youfan.analyEntity.tuangou.TuanGouanalyEntity;
import org.apache.flink.api.common.serialization.SimpleStringSchema;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer;

import java.util.Properties;

public class ProductTypeAnaly {
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
        DataStream<String> map = stream.flatMap(new ProductTypeMap());
        env.execute("ProductTypeAnaly");
    }
}
