package org.example.mapper;

import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.api.java.tuple.Tuple3;
import org.apache.flink.api.java.tuple.Tuple5;

public class AverageProfit2Mapper implements MapFunction<Tuple5<String,String,String,Integer,Integer>,Tuple3<String,String,Double>> {

    @Override
    public Tuple3<String, String, Double> map(Tuple5<String, String, String, Integer, Integer> input) throws Exception {
        return new Tuple3<String,String, Double>(input.f0,input.f1,new Double((input.f3*1.0)/input.f4));
    }
}
