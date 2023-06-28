package org.example.mapper;

import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.api.java.tuple.Tuple1;
import org.apache.flink.api.java.tuple.Tuple2;

public class WordCountMap1 implements MapFunction<String, Tuple1<String>> {


    @Override
    public Tuple1<String> map(String s) throws Exception {
        String str[]=s.split(",");
        return new Tuple1<>(str[0]);
    }
}
