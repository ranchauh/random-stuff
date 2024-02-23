package com.example.kafka.topic;

import com.example.kafka.model.Message;

import java.util.ArrayList;
import java.util.List;

public class Partition {
    private List<Message> queue;
    int recentReadOffset;
    int recentWriteOffset;

    public Partition() {
        this.queue = new ArrayList<>();
        recentReadOffset = 0;
        recentWriteOffset = 0;
    }

    public List<Message> readMessages(int numOfMessages) {
        if(numOfMessages > recentReadOffset) {
            return queue;
        } else {
            List<Message> messages = new ArrayList<>();
            for(int i = recentReadOffset; i<queue.size(); i++) {
                messages.add(queue.get(recentReadOffset));
            }
            return messages;
        }
    }

    public void writeMessages(List<Message> messages) {
        queue.addAll(messages);
        recentWriteOffset = recentWriteOffset + messages.size();
    }

    public void writeMessage(Message message) {
        queue.add(message);
        recentWriteOffset = recentWriteOffset + 1;
    }

}
