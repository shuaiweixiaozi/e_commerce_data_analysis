package com.youfan.analy;

import com.youfan.analy.conpus.ConpusMap;
import com.youfan.analy.conpus.ConpusReduce;
import com.youfan.analy.conpus.ConpusSink;
import com.youfan.analy.tuangou.TuanGouMap;
import com.youfan.analy.tuangou.TuanGouReduce;
import com.youfan.analy.tuangou.TuanGouSink;
import com.youfan.analyEntity.conpus.ConpusanalyEntity;
import com.youfan.analyEntity.tuangou.TuanGouanalyEntity;
import org.apache.flink.api.common.serialization.SimpleStringSchema;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.windowing.time.Time;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer;

import java.util.Properties;

public class ConpusinfoAnaly {
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
        DataStream<ConpusanalyEntity> map = stream.flatMap(new ConpusMap());
        DataStream<ConpusanalyEntity> conpusanalyreduce = map.keyBy("userId").timeWindowAll(Time.seconds(2)).reduce(new ConpusReduce());
        conpusanalyreduce.addSink(new ConpusSink());
        env.execute("ConpusinfoTopAnaly");
    }
}
