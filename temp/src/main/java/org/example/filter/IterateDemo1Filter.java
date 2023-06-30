package org.example.filter;

import org.apache.flink.api.common.functions.FilterFunction;
import org.apache.flink.api.java.tuple.Tuple2;


public class IterateDemo1Filter implements FilterFunction<Tuple2<Long,Integer>> {
    @Override
    public boolean filter(Tuple2<Long, Integer> val) throws Exception {
        if(val.f0==10) return false;
        else return true;
    }
}
