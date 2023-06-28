package org.example;

import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.api.java.tuple.Tuple3;
import org.apache.flink.api.java.tuple.Tuple5;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.example.mapper.AverageProfit1Mapper;
import org.example.mapper.AverageProfit2Mapper;
import org.example.reduce.AverageProfit1Reduce;

public class AverageProfit1 {
    public static void main(String[] args) throws Exception {
        final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        DataStream data=env.readTextFile("/Users/sakshamsaxena/Desktop/FlinkTut/InputFiles/avg.txt");
        DataStream<Tuple5<String,String,String,Integer,Integer>> mapped = data.map(new AverageProfit1Mapper());
        DataStream<Tuple5<String,String,String,Integer,Integer>> reduced = mapped.keyBy(0).reduce(new AverageProfit1Reduce());

        DataStream<Tuple3<String,String,Double>> profitPerMonth = reduced.map(new AverageProfit2Mapper());
        profitPerMonth.print();
        profitPerMonth.writeAsText("/Users/sakshamsaxena/Desktop/FlinkTut/OutputFiles/profit_per_month2.txt");

        env.execute("Avg Profit Per Month");

    }
}
