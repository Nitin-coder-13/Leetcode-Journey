package String;

import java.util.*;

public class LongestRepeatingcharacterReplacement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int k = sc.nextInt();
        System.out.println(characterReplacement(s, k));

    }

    public static int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int left = 0; // left boundary for window
        int maxFreq = 0;
        int maxWindow = 0;
        for (int right = 0; right < s.length(); right++) {
            // update the frequency of the current character
            freq[s.charAt(right) - 'A']++;
            // update the maxFrequency
            maxFreq = Math.max(maxFreq, freq[s.charAt(right) - 'A']);
            int window_length = right - left + 1;
            // if the window_length-max frequency > k , then we need to shrink the window
            if(window_length-maxFreq>k){
                freq[s.charAt(left) - 'A']--;
                left++;
            }
            window_length = right - left + 1;
            maxWindow = Math.max(maxWindow, window_length);

        }
        return maxWindow;
    }
}
