package example;

import org.apache.flink.api.java.DataSet;
import org.apache.flink.api.java.ExecutionEnvironment;

import java.util.List;

public class FilterAndReduce {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, Flink Batch Stream");
        ///createCollectionEnvironment
        ExecutionEnvironment env=ExecutionEnvironment.createCollectionsEnvironment();
        DataSet<Integer> data=env.fromElements(1,2,3,4,5,6,7,7,8,6,5,422);// way of creating dataset
        List<Integer> records=data.filter(e->e>1)
                .reduce(((integer, t1) -> integer+t1))
                .collect();
        System.out.println("Element of records List!");
        records.stream().forEach(e->{
            System.out.println(e);
        });





    }

}
