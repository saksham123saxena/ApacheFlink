package org.example;

import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.datastream.IterativeStream;
import org.apache.flink.streaming.api.environment.StreamContextEnvironment;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.example.filter.IterateDemo1Filter;
import org.example.filter.IterateDemo1FilterV1;
import org.example.mapper.IterateDemo1Mapper;
import org.example.mapper.IterateDemo1MapperV1;

public class IterateDemo1 {
    public static void main(String[] args) throws Exception {
        final StreamExecutionEnvironment env = StreamContextEnvironment.getExecutionEnvironment();
        DataStream<Tuple2<Long,Integer>> data = env.generateSequence(0,500)
                .map(new IterateDemo1Mapper());
        System.out.println("data-stream of long and integer formate");
        data.print();
        IterativeStream<Tuple2<Long,Integer>> iteration=data.iterate(5000);
        DataStream<Tuple2<Long,Integer>> plusOne = iteration.map(new IterateDemo1MapperV1());
        System.out.println("after the first iteration");
        plusOne.print();

        DataStream<Tuple2<Long,Integer>> tenNotEqual = plusOne.filter(new IterateDemo1Filter());
        tenNotEqual.writeAsText("/Users/sakshamsaxena/Desktop/FlinkTut/OutputFiles/not-ten1.txt");
        iteration.closeWith(tenNotEqual);

        // data not feedback to iteration
        DataStream<Tuple2<Long,Integer>> tenEqual = plusOne.filter(new IterateDemo1FilterV1());
        tenEqual.writeAsText("/Users/sakshamsaxena/Desktop/FlinkTut/OutputFiles/ten1.txt");
        env.execute("ITERATION OPERATOR");
    }
}
