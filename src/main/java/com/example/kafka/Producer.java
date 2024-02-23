package com.example.kafka;

import com.example.kafka.model.Message;

import java.util.List;

public class Producer {
    private Kafka kafka;

    public Producer(Kafka kafka) {
        this.kafka = kafka;
    }

    public void produceMessage(Message message) {
        kafka.writeMessages(List.of(message));
    }
}
