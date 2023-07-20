package src.main.java.org.example;
import org.apache.flink.util.Collector;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.api.common.functions.FlatMapFunction;
/* parser imports */
import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.databind.JsonNode;
import org.apache.flink.shaded.jackson2.com.fasterxml.jackson.databind.ObjectMapper;
/* flink streaming twittter imports */
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.connectors.twitter.TwitterSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

import org.apache.flink.core.fs.Path;
//import org.apache.flink.api.common.serialization.SimpleStringEncoder;
//import org.apache.flink.streaming.api.functions.sink.filesystem.StreamingFileSink;
//import org.apache.flink.streaming.api.functions.sink.filesystem.rollingpolicies.DefaultRollingPolicy;

import java.util.Properties;

public class TwitterData {
    public static void main(String[] args) throws Exception {
        final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        Properties twitterCredentials = new Properties();
        twitterCredentials.setProperty(TwitterSource.CONSUMER_KEY, "QickJfJi6SfeIWP2GHWAMLDRK");
        twitterCredentials.setProperty(TwitterSource.CONSUMER_SECRET, "5IPZXLwZdorjYGvrzzCPnBS0RtMbYj8tLEWAE47DOjsMJUxMvF");
        twitterCredentials.setProperty(TwitterSource.TOKEN, "1679038609478012930-HzPuN75NFHbl9E6FLnSteHdKbChgLl");
        twitterCredentials.setProperty(TwitterSource.TOKEN_SECRET, "c6p8jcKN8jnekCL1qOL7uyoa1Tw4rFFpsJnejk3oRCquK");

        DataStream <String> twitterData = env.addSource(new TwitterSource(twitterCredentials));
        twitterData.print();
        System.out.println(twitterData);
//        twitterData.writeAsText("/Users/sakshamsaxena/Desktop/FlinkTut/OutputFiles/twitteroutput1.txt");

//        twitterData.flatMap(new TweetParser()).writeAsText("/Users/sakshamsaxena/Desktop/FlinkTut/OutputFiles/twitteroutput.txt");

//        twitterData.flatMap(new TweetParser())
//                .addSink(StreamingFileSink
//                        .forRowFormat(new Path("/home/jivesh/tweet"),
//                                new SimpleStringEncoder < Tuple2 < String, Integer >> ("UTF-8"))
//                        .withRollingPolicy(DefaultRollingPolicy.builder().build())
//                        .build());

        env.execute("Twitter Example");
    }

    public static class TweetParser implements FlatMapFunction < String, Tuple2 < String, Integer >> {

        public void flatMap(String value, Collector < Tuple2 < String, Integer >> out) throws Exception {
            ObjectMapper jsonParser = new ObjectMapper();
            JsonNode node = jsonParser.readValue(value, JsonNode.class);

            boolean isEnglish =
                    node.has("user") &&
                            node.get("user").has("lang") &&
                            node.get("user").get("lang").asText().equals("en");

            boolean hasText = node.has("text");

            if (isEnglish && hasText) {
                String tweet = node.get("text").asText();

                out.collect(new Tuple2 < String, Integer > (tweet, 1));
            }
        }
    }
}
