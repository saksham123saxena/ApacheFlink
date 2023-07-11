package org.example;

import org.apache.commons.lang3.text.CompositeFormat;
import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.api.java.tuple.Tuple3;
import org.apache.flink.api.java.tuple.Tuple4;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.windowing.assigners.TumblingEventTimeWindows;
import org.apache.flink.streaming.api.windowing.assigners.TumblingProcessingTimeWindows;
import org.apache.flink.streaming.api.windowing.time.Time;
import org.apache.flink.util.Collector;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WordCountSocket {
    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env=StreamExecutionEnvironment.createLocalEnvironment();
        DataStream<Tuple4<String,Integer,LocalDate,String>> dataStream=env.socketTextStream("localhost",9090)
                .flatMap(new Splitter())
                .keyBy(0)
                .window(TumblingProcessingTimeWindows.of(Time.seconds(1)))
                .sum(1);
        dataStream.print();
        env.execute("word-count-program");
    }

    public static class Splitter implements FlatMapFunction<String, Tuple4<String,Integer,LocalDate,String>>{

        @Override
        public void flatMap(String s, Collector<Tuple4<String,Integer, LocalDate,String>> out) throws Exception {
            for (String ele : s.toLowerCase().split("\\W+")) {
                if (ele.length() > 0) {
                    /**
                     *  SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                     *     Date date = new Date();
                     *     System.out.println(formatter.format(date));
                     */
                    SimpleDateFormat datef = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                    Date date=new Date();
                    LocalDate d=LocalDate.now();
                    out.collect(new Tuple4<>(ele, 1,d,datef.format(date)));
                }
            }

        }
    }
}
