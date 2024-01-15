package org.example;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

public class Producer {
    public static void main(String[] args) {
        // Step # 1: create a producer and connect to the cluster
        // Step # 2: define the topic name
        // Step # 3: create a message record
        // Step # 4: send the record to the cluster

        Logger logger = LoggerFactory.getLogger(Producer.class.getName());
        // step # 1: create a producer and connect to the cluster
// get connection data from the configuration file

//        Properties properties = Utils.loadProperties();
        Properties properties = new Properties();
        //b-1.kafka-production.r8fw5m.c3.kafka.ap-south-1.amazonaws.com:9092,b-2.kafka-production.r8fw5m.c3.kafka.ap-south-1.amazonaws.com:9092,b-3.kafka-production.r8fw5m.c3.kafka.ap-south-1.amazonaws.com:9092");
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"kafka-dev-koo-dev.aivencloud.com:25390");
//        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"b-1.kafka-production.r8fw5m.c3.kafka.ap-south-1.amazonaws.com:9092,b-2.kafka-production.r8fw5m.c3.kafka.ap-south-1.amazonaws.com:9092,b-3.kafka-production.r8fw5m.c3.kafka.ap-south-1.amazonaws.com:9092");

        properties.put("key.serializer", StringSerializer.class.getName());
        properties.put("value.serializer", StringSerializer.class.getName());

        KafkaProducer<String,String> producer = new KafkaProducer<String, String>(properties);

        String topicName = "de-testing";

        int i=0;
        while(true){
            ProducerRecord<String,String> re=new ProducerRecord<>(topicName,"hello-worlds-"+i++);
            producer.send(re);
            System.out.println("value of i "+i);
//            producer.flush();
//            producer.close();
        }

    }

}
