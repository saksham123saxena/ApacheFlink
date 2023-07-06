package example.join;

import org.apache.flink.api.java.DataSet;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.api.java.tuple.Tuple3;

import java.util.List;

public class Join {
    public static void main(String[] args) throws Exception {
        ExecutionEnvironment env=ExecutionEnvironment.createCollectionsEnvironment();
        Tuple3<Integer,String,String> address=new Tuple3<>(1, "5th Avenue", "London");
        DataSet<Tuple3<Integer,String,String>> addresses=env.fromElements(address);


        Tuple2<Integer,String> firstTransaction=new Tuple2<>(1,"Transaction_1");
        DataSet<Tuple2<Integer,String>> transactions=env.fromElements(firstTransaction);

        List<Tuple2<Tuple2<Integer,String>,Tuple3<Integer,String,String>>> joined=transactions.join(addresses)
                .where(new IdKeySelectorTransactions())
                .equalTo(new IdKeySelectorAddresses())
                .collect();
        System.out.println("printing the join values");
        joined.stream().forEach(e->{
            System.out.println(e.f0+" - "+e.f1);
        });

    }
}
