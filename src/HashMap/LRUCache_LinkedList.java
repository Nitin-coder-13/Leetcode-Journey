package HashMap;

import java.util.*;

public class LRUCache_LinkedList {
    class Node {
        int key;
        int value;
        Node next;


        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    int capacity;
    private Node head;
    private Node tail;
    private int size;

    public LRUCache_LinkedList(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        Node prev = null;
        Node curr = head;
        while (curr != null) {
            if (curr.key == key) {
                if (curr != head) {
                    prev.next = curr.next;
                    curr.next = head;
                    head = curr;
                    if (curr == tail) {
                        tail = prev;
                    }
                }
                return curr.value;
            }
            prev = curr;
            curr = curr.next;
        }
        return -1;
    }

    public void put(int key, int value) {
        Node prev = null;
        Node curr = head;
        while (curr != null) {
            if (curr.key == key) {
                curr.value = value;
                if (curr != head) {
                    prev.next = curr.next;
                    if (curr == tail) { // same as one in get, bus likhne ka tareeka alag hai
                        tail = prev;
                    }
                    curr.next = head;
                    head = curr;
                }
                return;
            }
            prev = curr;
            curr = curr.next;
        }
        if (size == capacity) {// remove lru (tail)
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                Node temp = head;
                while (temp.next != tail) {
                    temp = temp.next;
                }
                temp.next = null;
                tail = temp;
            }
            size--;
        }
        size++;
        Node newNode = new Node(key, value);
        newNode.next = head;
        head = newNode;
        if (tail == null) {
            tail = newNode;
        }

    }
}

