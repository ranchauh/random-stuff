package com.example.kafka.model;

import com.example.kafka.Consumer;
import com.example.kafka.topic.Partition;
import com.example.kafka.topic.PartitionConsumer;
import com.example.kafka.topic.Topic;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Kafka {

    private Topic topic;

    private Map<Consumer, List<PartitionConsumer>> partitionConsumerMap;

    public Kafka() {
        partitionConsumerMap = new HashMap<>();
    }

    public void addTopic(String name, int partitionsCount) {
        topic = new Topic(name, partitionsCount);
    }





}
