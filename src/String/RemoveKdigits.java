package String;

import java.util.Stack;

public class RemoveKdigits {
    public static void main(String[] args) {
        String result = remove("1432219", 3);
        System.out.println(result);
    }

    public static String remove(String s, int k) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            while (!st.isEmpty() && k > 0 && st.peek() > c) {
                st.pop();
                k--;
            }
            st.push(c);
        }
        while (k > 0) {
            st.pop();
            k--;
        }
        if (st.isEmpty()) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < st.size(); i++) {
            sb.append(st.get(i));
        }
        int start = 0;
        while (start < sb.length() - 1 && sb.charAt(start) == '0') {
            start++;
        }
        return sb.substring(start);


    }

}