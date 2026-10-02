package HashMap;

import java.util.*;

public class LRUCache_array {
    class Node {
        int key;
        int value;
        long timestamp;

        public Node(int key, int value, long timestamp) {
            this.key = key;
            this.value = value;
            this.timestamp = timestamp;
        }
    }

    int capacity;
    long counter = 0;
    ArrayList<Node> cache = new ArrayList<>();

    public LRUCache_array(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        for (int i = 0; i < cache.size(); i++) {
            if (cache.get(i).key == key) {
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
                counter++;
                cache.get(i).timestamp = counter;
                return;
            }
        }
        if (cache.size() == capacity) {
            long min_time = Long.MAX_VALUE;
            int min_index = -1;
            for (int i = 0; i < cache.size(); i++) {
                if (cache.get(i).timestamp < min_time) {
                    min_time = cache.get(i).timestamp;
                    min_index = i;
                }
            }
            cache.remove(min_index);
        }
        // add the node
        counter++;
        cache.add(new Node(key, value, counter));


    }
}
