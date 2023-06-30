package org.example.mapper;

import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.api.java.tuple.Tuple1;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.streaming.api.datastream.DataStream;

public class CabApplicationMapper implements MapFunction<String, Tuple1<String>> {
    @Override
    public Tuple1<String> map(String s) throws Exception {
        String[] ans=s.split(",");

        return new Tuple1<>(ans[6]);
    }
}
