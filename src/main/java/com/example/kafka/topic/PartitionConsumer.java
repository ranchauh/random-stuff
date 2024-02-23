package com.example.kafka.topic;

import com.example.kafka.Consumer;

public class PartitionConsumer {

    private Partition partition;

    private Consumer consumer;

    private int consumerOffset;

    public PartitionConsumer(Partition partition, Consumer consumer) {
        this.partition = partition;
        this.consumer = consumer;
        this.consumerOffset = 0;
    }

    public PartitionConsumer(Consumer consumer, int consumerOffset) {
        this.consumer = consumer;
        this.consumerOffset = consumerOffset;
    }

    public Partition getPartition() {
        return partition;
    }

    public void setPartition(Partition partition) {
        this.partition = partition;
    }

    public Consumer getConsumer() {
        return consumer;
    }

    public void setConsumer(Consumer consumer) {
        this.consumer = consumer;
    }

    public int getConsumerOffset() {
        return consumerOffset;
    }

    public void setConsumerOffset(int consumerOffset) {
        this.consumerOffset = consumerOffset;
    }
}
