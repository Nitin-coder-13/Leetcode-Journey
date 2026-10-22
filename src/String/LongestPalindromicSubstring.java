package String;

import java.util.*;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("12154678"));
        System.out.println(longestPalindrome2("12154678"));
    }

    public static String longestPalindrome(String s) { // brute force approach
        int beg = 0;
        int end = 0;
        int length = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                boolean ans = isvalid(s.substring(i, j));
                if (ans) {
                    int cur_length = j - i;
                    if (cur_length > length) {
                        length = cur_length;
                        beg = i;
                        end = j;
                    }
                }
            }
        }
        return s.substring(beg, end);

    }

    public static boolean isvalid(String str) {
        int i = 0;
        int j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
     // optimised approach
    static int resultStart;
    static int resultLength;

    public static String longestPalindrome2(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        for (int start = 0; start < len - 1; start++) {
            expandRange(s, start, start); // for odd length
            expandRange(s, start, start + 1); // for even length
        }
        return s.substring(resultStart, resultStart + resultLength);
    }

    private static void expandRange(String str, int left, int right) {
        while (left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
            left--;
            right++;
        }
        if (resultLength < right-left - 1) {
            resultStart = left + 1;
            resultLength = right - left - 1;
        }
    }
}
