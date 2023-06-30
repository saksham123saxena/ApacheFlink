package org.example.mapper;

import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.api.java.tuple.Tuple4;

public class AggregationMapper implements MapFunction<String, Tuple4<String,String,String,Integer>> {
    @Override
    public Tuple4<String, String, String, Integer> map(String s) throws Exception {
        String [] ans=s.split(",");
        Tuple4<String,String,String,Integer> dataStream=new Tuple4<>(ans[1],ans[2],ans[3],Integer.parseInt(ans[4]));
        return dataStream;
    }
}
