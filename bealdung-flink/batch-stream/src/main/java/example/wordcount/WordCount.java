package example.wordcount;

import org.apache.flink.api.java.DataSet;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.aggregation.Aggregations;
import org.apache.flink.api.java.tuple.Tuple2;

import java.util.Arrays;
import java.util.List;

public class WordCount {
    public static void main(String[] args) throws Exception {
        ExecutionEnvironment env=ExecutionEnvironment.createCollectionsEnvironment();
        List<String> lines = Arrays.asList(
                "This is a first sentence",
                "This is a second sentence with a one word");
        DataSet<Tuple2<String,Integer>> result=StartWordCount(env,lines);
        result.print();
        List<Tuple2<String,Integer>> ans=result.collect();
        ans.stream().forEach(e->{
            System.out.println(e.f0+"   "+e.f1);
        });

    }

    //function for start-word-count program
    public static DataSet<Tuple2<String,Integer>> StartWordCount(ExecutionEnvironment env, List<String> text){
        DataSet<String> records=env.fromCollection(text);
        return records.flatMap(new FlatMapWordCount())
                .groupBy(0)
                .aggregate(Aggregations.SUM,1);
    }
}
