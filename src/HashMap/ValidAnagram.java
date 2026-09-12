package HashMap;

import java.util.*;

public class ValidAnagram {
    public static void main(String[] args) {
        System.out.println(isAnagram_("anagram", "nagaram"));
    }

    public static boolean isAnagram_(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map1.put(s.charAt(i), map1.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            map2.put(t.charAt(i), map2.getOrDefault(t.charAt(i), 0) + 1);
        }
        for (char keys : map1.keySet()) {
            if (!map1.get(keys).equals(map2.get(keys))) {
                return false;
            }
        }
        return true;
    }
}
