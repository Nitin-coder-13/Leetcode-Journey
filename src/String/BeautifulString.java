package String;

import java.util.*;

public class BeautifulString {
    public static void main(String[] args) {
        System.out.println(minChanges("11000111"));
    }

    public static int minChanges(String s) {
        int n = s.length();
        int minops = 0;
        for (int i = 0; i < n; i += 2) {
            if (s.charAt(i) != s.charAt(i + 1)) {
                minops++;
            }
        }
        return minops;
    }
}
