package HashMap;

import java.util.*;

public class LFUCache_array {
    class Node {
        int key;
        int value;
        int frequency;
        long timestamp;

        public Node(int key, int value, int frequency, long timestamp) {
            this.key = key;
            this.value = value;
            this.frequency = frequency;
            this.timestamp = timestamp;
        }
    }

    long counter = 0;
    ArrayList<Node> cache = new ArrayList<>();
    int capacity;

    public LFUCache_array(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        for (int i = 0; i < cache.size(); i++) {
            if (cache.get(i).key == key) {
                cache.get(i).frequency++;
                counter++;
                cache.get(i).timestamp = counter;
                return cache.get(i).value;
            }
        }
        return -1;
    }

    public void put(int key, int value) {
        for (int i = 0; i < cache.size(); i++) {
            if (cache.get(i).key == key) {
                cache.get(i).value = value;
                cache.get(i).frequency++;
                counter++;
                cache.get(i).timestamp = counter;
                return;
            }
        }
        if (cache.size() == capacity) {
            long min_freq = Long.MAX_VALUE;
            long min_time = Long.MAX_VALUE;
            int min_index = -1;
            for (int i = 0; i < cache.size(); i++) {
                if (cache.get(i).frequency < min_freq || cache.get(i).frequency == min_freq && cache.get(i).timestamp < min_time) {
                    min_freq = cache.get(i).frequency;
                    min_time = cache.get(i).timestamp;
                    min_index = i;
                }
            }
            cache.remove(min_index);
        }
        counter++;
        Node newNode = new Node(key, value, 1, counter);
        cache.add(newNode);
    }
}

