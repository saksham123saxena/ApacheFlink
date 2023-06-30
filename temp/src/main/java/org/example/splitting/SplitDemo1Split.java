package org.example.splitting;

import org.apache.flink.streaming.api.collector.selector.OutputSelector;

import java.util.ArrayList;
import java.util.List;

public class SplitDemo1Split implements OutputSelector<Integer> {
    @Override
    public Iterable<String> select(Integer val) {
        List<String> out = new ArrayList<>();
        if (val%2==0) out.add("even-element");
        else out.add("odd-element");
        return out;
    }
}
