package Bitmasking;

import java.util.*;

public class MaximumProductOfWordLengths {
    public static void main(String[] args) {
     System.out.println(maxProduct(new String[]{"abcw","baz","foo","bar","xtfn","abcdef"}));
    }

    public static int maxProduct(String[] words) {
        int len = words.length;
        int[] state = new int[len];
        for (int i = 0; i < len; i++) {
            state[i] = getStateFromString(words[i]);
        }
        int ans = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if ((state[i] & state[j]) == 0) {
                    ans = Math.max(ans, words[i].length() * words[j].length());
                }
            }
        }
        return ans;
    }

    // important concept
    public static int getStateFromString(String str) {
        int state=0;
        for(char c:str.toCharArray()) {
            // getting index
            int index=c-'a';
            state |= 1<<index;
        }
        return state;
    }

}
