package HashMap;

import java.util.*;

public class LFUCache_LinkedList {
    class Node {
        int key;
        int value;
        int frequency;
        Node next;
        long timestamp;

        Node(int key, int value, int frequency, long timestamp) {
            this.key = key;
            this.value = value;
            this.frequency = frequency;
            this.timestamp = timestamp;
        }
    }

    long counter = 0;
    int capacity;
    private Node head;
    private Node tail;
    private int size;

    public LFUCache_LinkedList(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        Node temp = head;
        while (temp != null) {
            if (temp.key == key) {
                counter++;
                temp.frequency++;
                temp.timestamp = counter;
                return temp.value;
            }
            temp = temp.next;
        }
        return -1;
    }

    public void put(int key, int value) {
        Node temp = head;
        while (temp != null) {
            if (temp.key == key) {
                temp.value = value;
                temp.frequency++;
                counter++;
                temp.timestamp = counter;
                return;
            }
            temp = temp.next;
        }
        if (size == capacity) {
            long min_freq = Long.MAX_VALUE;
            long min_timestamp = Long.MAX_VALUE;
            Node min_node = null;
            Node prev_min = null;
            Node prev = null;
            temp = head;
            while (temp != null) {
                if (temp.frequency < min_freq || temp.frequency == min_freq && temp.timestamp < min_timestamp) {
                    min_freq = temp.frequency;
                    min_timestamp = temp.timestamp;
                    min_node = temp;
                    prev_min = prev;

                }
                prev = temp;
                temp = temp.next;
            }
            if (min_node == head) {
                head = head.next;
            } else {
                prev_min.next = min_node.next;
            }
            if (min_node == tail) {
                tail = prev_min;
            }
            size--;
        }
        size++;
        counter++;
        Node new_node = new Node(key, value, 1, counter);
        new_node.next = head;
        head = new_node;
        if (tail == null) {
            tail = new_node;
        }
    }
}
