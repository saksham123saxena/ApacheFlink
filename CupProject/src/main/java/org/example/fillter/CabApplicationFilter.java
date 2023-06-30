package org.example.fillter;

import org.apache.flink.api.common.functions.FilterFunction;
import org.apache.flink.api.java.tuple.Tuple0;
import org.apache.flink.api.java.tuple.Tuple1;

public class CabApplicationFilter implements FilterFunction<Tuple1<String>> {
    @Override
    public boolean filter(Tuple1<String> val) throws Exception {
        if ( val.f0==null | val.f0.equals("'null'")) return false;
        else return true;
    }
}
