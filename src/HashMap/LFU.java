package HashMap;

import java.util.*;

public class LFU {
    class DLL {
        Node head;
        Node tail;
    }

    class Node {
        int key;
        int value;
        int frequency;
        Node next;
        Node prev;

        Node(int key, int value, int frequency) {
            this.key = key;
            this.value = value;
            this.frequency = frequency;
        }
    }

    private HashMap<Integer, Node> keyNode = new HashMap<>();
    private HashMap<Integer, DLL> freqNode = new HashMap<>();
    private int size;
    int capacity;
    int minFreq = 0;

    public LFU(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        Node nn = keyNode.get(key); // keyNode se node nikalo
        if (nn == null) return -1; // nhi mila toh return -1
        int oldFreq = nn.frequency; // old frequency ki dll se hatao
        DLL oldList = freqNode.get(oldFreq); // wo frequency ki doubly linked list me aa gye
        removeNode(oldList, nn);
        if (oldList.head == null) {
            freqNode.remove(oldFreq);
            if (minFreq == oldFreq) {
                minFreq++;
            }
        }
        nn.frequency++;
        DLL newList = freqNode.get(nn.frequency);
        if (newList == null) {
            newList = new DLL();
            freqNode.put(nn.frequency, newList);
        }
        addToHead(newList, nn);
        return nn.value;

    }

    private void removeNode(DLL oldList, Node nn) {
        if (nn.prev != null) {
            nn.prev.next = nn.next;
        } else {
            oldList.head = nn.next;
        }
        if (nn.next != null) {
            nn.next.prev = nn.prev;
        } else {
            oldList.tail = nn.prev;
        }
    }

    private void addToHead(DLL newList, Node newNode) {
        newNode.prev = null;
        newNode.next = newList.head;
        if (newList.head != null) {
            newList.head.prev = newNode;
        } else { // meaning empty list hai
            newList.tail = newNode;
        }
        newList.head = newNode;
    }

    public void put(int key, int value) {
        Node nn = keyNode.get(key);
        if (nn != null) {
            int freq = nn.frequency;
            DLL oldList = freqNode.get(freq);
            nn.value = value;
            removeNode(oldList, nn);
            if (oldList.head == null) {
                freqNode.remove(freq);
                if (minFreq == freq) {
                    minFreq++;
                }
            }
            nn.frequency++;
            DLL newList = freqNode.get(nn.frequency);
            if (newList == null) {
                newList = new DLL();
                freqNode.put(nn.frequency, newList);
            }
            addToHead(newList, nn);
            return;
        }
        if (size == capacity) {
            DLL minList = freqNode.get(minFreq);
            Node victim = minList.tail;
            keyNode.remove(victim.key);
            removeNode(minList, victim);
            if (minList.head == null) {
                freqNode.remove(minFreq);
            }
            size--;
        }
        Node newNode = new Node(key, value, 1);
        DLL newList = freqNode.get(1);
        if (newList == null) {
            newList = new DLL();
            freqNode.put(1, newList);
        }
        addToHead(newList, newNode);
        keyNode.put(key, newNode);
        minFreq = 1;
        size++;

    }
}
