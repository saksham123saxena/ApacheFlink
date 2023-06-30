//package org.example;
//
//import org.apache.flink.api.java.utils.ParameterTool;
//import org.apache.flink.streaming.api.datastream.DataStream;
//import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
//import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
//import org.apache.flink.util.OutputTag;
//
//public class SplitDemo1V1 {
//    public static void main(String[] args) {
//        final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
//        final ParameterTool params = ParameterTool.fromArgs(args);
//        env.getConfig().setGlobalJobParameters(params);
//        DataStream<String> text = env.readTextFile("");
//
//        final OutputTag<String> evenOut = new OutputTag<>("even-string-output");
//        final OutputTag<Integer> oddOut = new OutputTag<>("odd-int-output");
//
////        SingleOutputStreamOperator<Integer> mainStream = text.process((value)->{
//
//        });
//    }
//}
