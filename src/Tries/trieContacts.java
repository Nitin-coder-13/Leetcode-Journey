package Tries;

import java.util.*;

public class trieContacts {
    private class Node {
        char data;
        HashMap<Character, Node> child = new HashMap<Character, Node>();
        boolean IsTerminal;
        int count = 0;
    }

    private Node root;

    public trieContacts() {
        Node nn = new Node();
        nn.data = '*';
        root = nn;
    }

    public void addName(String name) {
        Node temp = root;
        for (int i = 0; i < name.length(); i++) {
            char c = name.charAt(i);
            if (temp.child.containsKey(c)) {
                temp = temp.child.get(c);
                temp.count++;
            } else {
                Node newNode = new Node();
                newNode.data = c;
                newNode.count = 1;
                temp.child.put(c, newNode);
                temp = newNode;
            }
        }
        temp.IsTerminal = true;
    }

    public int findpartial(String partial) {
        Node temp = root;
        for (int i = 0; i < partial.length(); i++) {
            char c = partial.charAt(i);
            if (!temp.child.containsKey(c)) {
                return 0;
            }
            temp = temp.child.get(c);
        }
        return temp.count;
    }

    public static void main(String[] args) {
        trieContacts t = new trieContacts();
        t.addName("hack");
        t.addName("hacker rank");
        System.out.println(t.findpartial("hac"));
        System.out.println(t.findpartial("hak"));
    }
}
