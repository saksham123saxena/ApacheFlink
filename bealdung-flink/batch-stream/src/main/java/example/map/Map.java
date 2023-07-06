package example.map;

import org.apache.flink.api.java.DataSet;
import org.apache.flink.api.java.ExecutionEnvironment;

import java.util.Arrays;
import java.util.List;

public class Map extends Person {
    public static void main(String[] args) throws Exception {
        ExecutionEnvironment env=ExecutionEnvironment.createCollectionsEnvironment();
        DataSet<Person> dataPersonSource=env.fromCollection(
                Arrays.asList(
                        new Person(12,"local"),
                        new Person(21,"vokal")
                )
        );
        dataPersonSource.print();
        List<Integer> agesPerson=dataPersonSource
                .map(e->e.age)
                .collect();
        List<String> namesPerson=dataPersonSource
                .map(e->e.name)
                .collect();
        System.out.println("Age of the Persons");
        agesPerson.stream().forEach(e->{
            System.out.println(e);
        });
        System.out.println("Name of the Persons");
        namesPerson.stream().forEach(e->{
            System.out.println(e);
        });

    }
}
