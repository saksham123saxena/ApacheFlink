package org.example.mapper;

import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.api.java.tuple.Tuple2;

public class IterateDemo1MapperV1 implements MapFunction<Tuple2<Long,Integer>,Tuple2<Long,Integer>> {
    @Override
    public Tuple2<Long, Integer> map(Tuple2<Long, Integer> val) throws Exception {
        if(val.f0==10) return val;
        else return new Tuple2<>(val.f0+1,val.f1+1);
    }
}
