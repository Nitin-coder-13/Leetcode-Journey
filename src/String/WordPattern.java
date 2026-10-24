package String;

import java.util.*;

public class WordPattern {
    public static void main(String[] args) {
        String pattern = "abba";
        String str = "dog cat cat dog";
        System.out.println(wordPattern_(pattern, str));
    }

    public static boolean wordPattern_(String Pattern, String str) {
        HashMap<Character, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        String[] words = str.split(" ");
        if (Pattern.length() != words.length) return false;
        for (int i = 0; i < words.length; i++) {
            if (map.containsKey(Pattern.charAt(i))) {
                if(!map.get(Pattern.charAt(i)).equals(words[i])) {
                    return false;
                }
            } else {
                if (set.contains(words[i])) {
                    return false;
                }
            }
            map.put(Pattern.charAt(i), words[i]);
            set.add(words[i]);
        }
        return true;
    }
}
