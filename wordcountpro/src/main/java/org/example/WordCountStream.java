package org.example;

import org.apache.flink.api.java.tuple.Tuple;
import org.apache.flink.api.java.tuple.Tuple1;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.api.java.utils.ParameterTool;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.example.filter.WordCountFilter;
import org.example.mapper.WordCountMap;
import org.example.mapper.WordCountMap1;

public class WordCountStream {
    public static void main(String[] args) throws Exception {
        final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        final ParameterTool parms = ParameterTool.fromArgs(args);
        env.getConfig().setGlobalJobParameters(parms);
        DataStream<String> text1=env.readTextFile("/Users/sakshamsaxena/Desktop/FlinkTut/InputFiles/words.txt");
        DataStream<Tuple1<String>> text=text1.map(new WordCountMap1());
        DataStream<Tuple2<String,Integer>> counts = text.filter(new WordCountFilter())
                .map(new WordCountMap())
                .keyBy(0).sum(1);
          counts.print();
        counts.writeAsText("/Users/sakshamsaxena/Desktop/FlinkTut/OutputFiles/WordCount3.txt");


        env.execute("Word Count Streaming!!");
    }
}
