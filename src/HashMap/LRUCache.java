package HashMap;

import java.util.*;

public class LRUCache {
    class Node {
        int key;
        int value;
        Node next;
        Node prev;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Map<Integer, Node> cache = new HashMap<>();
    int capacity;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        }
        removeNode(node);
        addToHead(node);
        return node.value;

    }

    private void removeNode(Node node) {
        if (node.prev != null) {
            node.prev.next = node.next;
        } else {
            head = node.next;
        }
        if (node.next != null) {
            node.next.prev = node.prev;
        } else {
            tail = node.prev;
        }
    }

    private void addToHead(Node node) {
        node.prev = null;
        node.next = head;
        if (head != null) {
            head.prev = node;
        } else {
            tail = node;
        }
        head = node;
    }

    public void put(int key, int value) {
        Node nn = cache.get(key);
        if (nn != null) { // if key exists update the value
            nn.value = value;
            removeNode(nn);
            addToHead(nn);
            return;
        }
        if (cache.size() == capacity) { // remove the lru (the tail)
            Node lru=tail;
            removeNode(lru); // doubly linked list se bhi hatao
            cache.remove(lru.key); // map se bhi hatao

        }
        Node newNode = new Node(key, value);
        addToHead(newNode);
        cache.put(key, newNode);
    }
}

