package org.example;

import org.apache.flink.api.java.tuple.Tuple4;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.example.mapper.AggregationMapper;

public class Aggregation2 {
    public static void main(String[] args) throws Exception {
        final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        DataStream<String> data= env.readTextFile("/Users/sakshamsaxena/Desktop/FlinkTut/InputFiles/avg.txt");
        DataStream<Tuple4<String,String,String,Integer>> text=data.map(new AggregationMapper());
//        text.keyBy(0).sum(3).writeAsText("/Users/sakshamsaxena/Desktop/FlinkTut/OutputFiles/sum.txt");
//        text.keyBy(0).min(3).writeAsText("/Users/sakshamsaxena/Desktop/FlinkTut/OutputFiles/min.txt");
//        text.keyBy(0).minBy(3).writeAsText("/Users/sakshamsaxena/Desktop/FlinkTut/OutputFiles/minby.txt");
//        text.keyBy(0).max(3).writeAsText("/Users/sakshamsaxena/Desktop/FlinkTut/OutputFiles/max.txt");
//        text.keyBy(0).maxBy(3).writeAsText("/Users/sakshamsaxena/Desktop/FlinkTut/OutputFiles/maxby.txt");


        env.execute("All Aggregation");
    }
}
