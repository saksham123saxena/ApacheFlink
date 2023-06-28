package org.example.mapper;

import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.api.java.tuple.Tuple5;

public class AverageProfit1Mapper implements MapFunction<String, Tuple5<String,String,String,Integer,Integer>> {
    @Override
    public Tuple5<String, String, String, Integer, Integer> map(String s) throws Exception {
        String[] words = s.split(",");
        return new Tuple5<String, String, String, Integer, Integer>(words[1],words[2],words[3],Integer.parseInt(words[4]),1);
    }
}
