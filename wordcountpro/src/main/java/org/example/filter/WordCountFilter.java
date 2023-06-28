package org.example.filter;

import org.apache.flink.api.common.functions.FilterFunction;
import org.apache.flink.api.java.tuple.Tuple1;

public class WordCountFilter implements FilterFunction<Tuple1<String>> {
    @Override
    public boolean filter(Tuple1<String> s) throws Exception {
        String st=s.f0;
        return st.startsWith("N");
    }
}
