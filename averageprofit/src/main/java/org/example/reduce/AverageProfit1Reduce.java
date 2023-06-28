package org.example.reduce;

import org.apache.flink.api.common.functions.ReduceFunction;
import org.apache.flink.api.java.tuple.Tuple5;

public class AverageProfit1Reduce implements ReduceFunction<Tuple5<String, String, String, Integer, Integer>> {
    @Override
    public Tuple5<String, String, String, Integer, Integer> reduce(Tuple5<String, String, String, Integer, Integer> input,
                                                                   Tuple5<String, String, String, Integer, Integer> output) throws Exception {
        return new Tuple5<String, String, String, Integer, Integer>(input.f0,input.f1,input.f2,input.f3+output.f3,input.f4+output.f4);
    }
}
