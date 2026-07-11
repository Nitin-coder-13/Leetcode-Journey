package Tries;

import java.util.HashMap;

public class longestcommonprefix {
    private class Node {
        char data;
        HashMap<Character, Node> child = new HashMap<Character, Node>();
        boolean IsTerminal;
    }

    private Node root;

    public longestcommonprefix() {
        Node nn = new Node();
        nn.data = '*';
        root = nn;
    }

    public void insert(String word) {
        Node temp = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (temp.child.containsKey(ch)) {
                temp = temp.child.get(ch);
            } else {
                Node newNode = new Node();
                newNode.data = ch;
                temp.child.put(ch, newNode);
                temp = newNode;
            }
        }
        temp.IsTerminal = true;
    }

    public static String longestCommonPrefix(String[] strs) {
        longestcommonprefix s = new longestcommonprefix();
        for (int i = 0; i < strs.length; i++) {
            s.insert(strs[i]);
        }
        StringBuilder ans = new StringBuilder();
        Node temp = s.root;
        while (temp.child.size() == 1 && !temp.IsTerminal) {
            for (char key : temp.child.keySet()) {
                ans.append(key);
                temp = temp.child.get(key);
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
    String[] str={"dog","racecar","car"};
    System.out.println(longestCommonPrefix(str));
    }
}
