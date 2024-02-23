package com.example.kafka.topic;

import java.util.ArrayList;
import java.util.List;

public class Topic {
    private String name;
    private static int DEFAULT_PARTITIONS = 3;
    private List<Partition> partitions;

    public Topic(String name) {
        this.name = name;
        this.partitions = new ArrayList<>(DEFAULT_PARTITIONS);
        for(int i=0; i<DEFAULT_PARTITIONS; i++) {
            this.partitions.add(new Partition());
        }
    }

    public Topic(String name, int partitionCount) {
        this.name = name;
        this.partitions = new ArrayList<>(partitionCount);
        for(int i=0; i<partitionCount; i++) {
            this.partitions.add(new Partition());
        }
    }

    public List<Partition> getPartitions() {
        return this.partitions;
    }

    public Partition getPartition(int num) {
        return this.partitions.get(num);
    }

    public int numberOfPartitions() {
        return this.partitions.size();
    }

}
