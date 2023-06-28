package org.example.mapper;

import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.api.java.tuple.Tuple1;
import org.apache.flink.api.java.tuple.Tuple2;

public class WordCountMap implements MapFunction<Tuple1<String>, Tuple2<String,Integer>> {
    @Override
    public Tuple2<String, Integer> map(Tuple1<String> s) throws Exception {
        return new Tuple2<>(s.f0,Integer.valueOf(1));
    }
}
