package example.join;

import org.apache.flink.api.java.functions.KeySelector;
import org.apache.flink.api.java.tuple.Tuple2;

public class IdKeySelectorTransactions implements KeySelector<Tuple2<Integer,String>,Integer> {
    @Override
    public Integer getKey(Tuple2<Integer, String> val) throws Exception {
        return val.f0;
    }
}
