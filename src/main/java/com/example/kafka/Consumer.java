package com.example.kafka;

import com.example.kafka.model.Message;

import java.util.List;

public class Consumer {
    private Kafka kafka;

    public Consumer(Kafka kafka) {
        this.kafka = kafka;
    }

    public List<Message> consumeMessage(int numOfMessages) {
        return kafka.readMessages(this, numOfMessages);
    }
}
