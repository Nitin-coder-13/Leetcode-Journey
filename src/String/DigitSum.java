package String;

import java.util.*;

public class DigitSum {
    public static void main(String[] args) {
        String s = "11111222223";
        int k = 3;
        System.out.println(digitSum(s, k));
    }

    public static String digitSum(String s, int k) {
        if (s.length() == k) {
            return s;
        }
        while (s.length() > k) {
            s=help(s, k);
        }
          return s;
    }

    private static String help(String s, int k) {
        StringBuilder st = new StringBuilder();
        int i = 0;
        for (; i + k < s.length(); i += k) {
            int sum = 0;
            for (int j = i; j < k + i; j++) {
                sum += s.charAt(j) - '0';
            }
            st.append(sum);
        }
        int ans = 0;
        while (i < s.length()) {
            ans += s.charAt(i) - '0';
            i++;
        }
        st.append(ans);
        return st.toString();
    }
}
