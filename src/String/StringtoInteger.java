package String;

import java.util.*;
import java.math.BigInteger;

public class StringtoInteger {
    public static void main(String[] args) {
        System.out.println(myAtoi(" -42abc95"));
    }

    public static int myAtoi(String s) {
        int i = 0;
        int n = s.length();
        // 1. skip leading space
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }
        // 2.Handle empty string or only spaces
        if (i == n) {
            return 0;
        }
        // 3. Determine sign
        int sign = 1;
        if (s.charAt(i) == '-') {
            sign = -1;
            i++;
        } else if (s.charAt(i) == '+') {
            i++;
        }
        // 4. construct number
        long num = 0;
        long limit = (sign == 1) ? Integer.MAX_VALUE : -(long) Integer.MIN_VALUE;
        while (i < n) {
            char ch = s.charAt(i);
            if (ch < '0' || ch > '9') {
                break;
            }
            int digit = ch - '0';
            num = num * 10 + digit;
            // 5. Handle overflow
            if (num > limit) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            i++;
        }
        return (int) (sign * num);
    }
}
