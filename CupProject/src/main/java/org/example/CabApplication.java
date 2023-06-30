package org.example;

import org.apache.flink.api.java.tuple.Tuple1;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamContextEnvironment;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.example.fillter.CabApplicationFilter;
import org.example.mapper.CabApplicationMapper;

import java.util.HashMap;
import java.util.Map;

public class CabApplication {
    public static void main(String[] args) throws Exception {
        final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        DataStream<String> data=env.readTextFile("/Users/sakshamsaxena/Desktop/FlinkTut/InputFiles/cab+flink.txt");
        DataStream<Tuple1<String>> dataDestination = data.map(new CabApplicationMapper())
                .filter(new CabApplicationFilter());
//        dataDestination.keyBy(0).max(0).writeAsText("/Users/sakshamsaxena/Desktop/FlinkTut/OutputFiles/cub-output-2.txt");
        dataDestination.print();
        DataStream<Tuple1<String>> kk=dataDestination.keyBy(0);
        System.out.println("KEY By operator");
        kk.print();
        Map<String,Integer> mp = new HashMap<>();
        System.out.println("distinct elements");


//        System.out.println(dataDestination.keyBy(0).max(0));

//        dataDestination.writeAsText("/Users/sakshamsaxena/Desktop/FlinkTut/OutputFiles/caboutput1.txt");

        env.execute("Cab Task!!");

    }
}
