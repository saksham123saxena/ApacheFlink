package example;

import org.apache.flink.api.common.operators.Order;
import org.apache.flink.api.java.DataSet;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.tuple.Tuple2;
import example.join.IdKeySelectorTransactions;

import java.util.List;

public class Sort {
    public static void main(String[] args) throws Exception{
        ExecutionEnvironment env=ExecutionEnvironment.createCollectionsEnvironment();
        Tuple2<Integer, String> secondPerson = new Tuple2<>(4, "Tom");
        Tuple2<Integer, String> thirdPerson = new Tuple2<>(5, "Scott");
        Tuple2<Integer, String> fourthPerson = new Tuple2<>(200, "Michael");
        Tuple2<Integer, String> firstPerson = new Tuple2<>(1, "Jack");
        DataSet<Tuple2<Integer,String>> transactions = env.fromElements(fourthPerson,secondPerson,fourthPerson,thirdPerson,firstPerson);
        List<Tuple2<Integer,String>> records=transactions
                .sortPartition(new IdKeySelectorTransactions(), Order.ASCENDING)
                .collect();
        records.stream().forEach(e->{
            System.out.println(e.f0+" "+e.f1);
        });



    }
}
