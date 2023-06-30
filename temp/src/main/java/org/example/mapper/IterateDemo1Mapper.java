package org.example.mapper;

import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.api.java.tuple.Tuple2;

public class IterateDemo1Mapper implements MapFunction<Long, Tuple2<Long,Integer>> {
    @Override
    public Tuple2<Long, Integer> map(Long val) throws Exception {
        return new Tuple2<>(val,0);
    }
}
