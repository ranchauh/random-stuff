package com.example.kafka;

import com.example.kafka.model.Message;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ClientApp {
    public static void main(String[] args) {
        Kafka kafka = new Kafka();

        Producer producer = new Producer(kafka);

        ExecutorService executorService = Executors.newCachedThreadPool();

        Future<?> producerFuture = executorService.submit(() -> {
            while(true) {
                producer.produceMessage(new Message());
            }
        });


    }
}
