package String;

import java.util.*;

public class FirstOccurence {
    public static void main(String[] args) {
        System.out.println(firstOccurence_("leetcode", "leeto"));
    }

    public static int firstOccurence_(String haystack, String needle) {
        if (haystack.length() < needle.length()) return -1;
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            boolean check = isValid(haystack.substring(i, i + needle.length()), needle);
            if (check) {
                return i;
            }
        }
        return -1;
    }

    private static boolean isValid(String haystack, String needle) {
        int i = 0;
        int j = 0;
        while (j < needle.length()) {
            if (haystack.charAt(i) != needle.charAt(j)) {
                return false;
            }
            i++;
            j++;
        }
        return true;
    }
}
