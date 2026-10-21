package String;

import java.util.*;

public class UniqueCharacterString {
    public static void main(String[] args) {
        System.out.println(uniqueCharacter("aabb"));
    }

    public static int uniqueCharacter(String words) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length(); i++) { // storing the frequencies
            map.put(words.charAt(i), map.getOrDefault(words.charAt(i), 0) + 1);
        }
        for (int i = 0; i < words.length(); i++) {
            if (map.containsKey(words.charAt(i)) && map.get(words.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }

}

