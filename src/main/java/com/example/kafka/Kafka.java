package com.example.kafka;

import com.example.kafka.Consumer;
import com.example.kafka.model.Message;
import com.example.kafka.topic.Partition;
import com.example.kafka.topic.PartitionConsumer;
import com.example.kafka.topic.Topic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Kafka {
    private Topic topic;

    private Map<Consumer, PartitionConsumer> partitionConsumerMap;

    public Kafka() {
        partitionConsumerMap = new HashMap<>();
    }

    public void addTopic(String name, int partitionsCount) {
        topic = new Topic(name, partitionsCount);
    }

    public void subScribeTopic(Consumer consumer) {

    }

    public void writeMessages(List<Message> messages) {
        int numOfPartitions = this.topic.numberOfPartitions();
        for(Message message : messages) {
            int hash = message.getContent().hashCode();
            int partitionNumber = hash % numOfPartitions;
            Partition partition = this.topic.getPartition(partitionNumber);
            partition.writeMessage(message);
        }
    }

    public List<Message> readMessages(Consumer consumer, int messageCount) {
        List<Partition> partitions = topic.getPartitions();
        List<Message> messages = new ArrayList<>();
        for(Partition partition : partitions) {
            messages.addAll(partition.readMessages(messageCount));
            if(messages.size() == messageCount) {
                return messages;
            }
        }
        updateConsumerOffset(consumer, messageCount);
        return messages;
    }

    private void updateConsumerOffset(Consumer consumer, int messageCount) {
        if(partitionConsumerMap.containsKey(consumer)) {
            PartitionConsumer partitionConsumer = partitionConsumerMap.get(consumer);
            partitionConsumer.setConsumerOffset(partitionConsumer.getConsumerOffset() + messageCount);
        } else {
            PartitionConsumer partitionConsumer = new PartitionConsumer(consumer, messageCount);
            partitionConsumerMap.put(consumer, partitionConsumer);
        }
    }

}
