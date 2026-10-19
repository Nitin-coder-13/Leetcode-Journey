package String;

import java.util.*;

public class ValidPalindromeII {
    public static void main(String[] args) {
        System.out.println((validPalindrome("adffdslcupuupuculsdffda")));
    }

    public static boolean validPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                boolean right_check = isPalindrome(s, i, j - 1);
                boolean left_check = isPalindrome(s, i + 1, j);
                return right_check || left_check;
            }
            i++;
            j--;
        }
        return true;
    }

    public static boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
