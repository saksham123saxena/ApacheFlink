package example.join;

import org.apache.flink.api.java.functions.KeySelector;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.api.java.tuple.Tuple3;

public class IdKeySelectorAddresses implements KeySelector<Tuple3<Integer,String,String>,Integer> {
    @Override
    public Integer getKey(Tuple3<Integer, String, String> val) throws Exception {
        return val.f0;
    }
}
