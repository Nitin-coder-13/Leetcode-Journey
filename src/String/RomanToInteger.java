package String;

import java.util.*;

public class RomanToInteger {
    public static void main(String[] args) {
        System.out.println(romanToInt_("XXIV"));
    }

    public static int romanToInt_(String s) {
        int result = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        for (int i = 0; i < s.length(); i++) {
            int cur = map.get(s.charAt(i));
            if (i + 1 < s.length() && cur < map.get(s.charAt(i + 1))) {
                result -= cur;
            } else {
                result += cur;
            }
        }
        return result;
    }
}
