package org.example;

import org.apache.flink.api.common.JobExecutionResult;
import org.apache.flink.api.java.utils.ParameterTool;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.datastream.SplitStream;
import org.apache.flink.streaming.api.environment.StreamContextEnvironment;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.example.mapper.SplitDemo1Mapper;
import org.example.splitting.SplitDemo1Split;

/**
 * /Users/sakshamsaxena/Desktop/FlinkTut/InputFiles/avg.txt");
 *         DataStream<Tuple4<String,String,String,Integer>> text=data.map(new AggregationMapper());
 *         text.keyBy(0).sum(3).writeAsText("/Users/sakshamsaxena/Desktop/FlinkTut/OutputFiles/sum.txt");
 *         text.keyBy(0).min(3).writeAsText("/Users/sakshamsaxena/Desktop/FlinkTut/OutputFiles/min.txt");
 *         text.keyBy(0).minBy(3).writeAsText("/Users/sakshamsaxena/Desktop/FlinkTut/OutputFiles/minby.txt"
 */
public class SplitDemo1 {
    public static void main(String[] args) throws Exception {
      final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
      final ParameterTool params = ParameterTool.fromArgs(args);
      env.getConfig().setGlobalJobParameters(params);
        DataStream<String> text = env.readTextFile("/Users/sakshamsaxena/Desktop/FlinkTut/InputFiles/oddeven.txt");
        SplitStream<Integer> evenOddStream = text.map(new SplitDemo1Mapper())
                .split(new SplitDemo1Split());

        evenOddStream.print();
        evenOddStream.writeAsText("/Users/sakshamsaxena/Desktop/FlinkTut/OutputFiles/fulloddeven.txt");

        DataStream<Integer> evenData = evenOddStream.select("even-element");
        DataStream<Integer> oddData = evenOddStream.select("odd-elements");

        evenData.writeAsText("/Users/sakshamsaxena/Desktop/FlinkTut/OutputFiles/evenans.txt");
        oddData.writeAsText("/Users/sakshamsaxena/Desktop/FlinkTut/OutputFiles/oddans.txt");

        env.execute("ODD EVEN BY SPLIT OPERATOR");

    }
}
