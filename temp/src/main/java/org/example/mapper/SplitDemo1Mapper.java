package org.example.mapper;

import org.apache.flink.api.common.functions.MapFunction;

public class SplitDemo1Mapper implements MapFunction<String,Integer> {
    @Override
    public Integer map(String s) throws Exception {
        return Integer.parseInt(s);
    }
}
