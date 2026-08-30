package Bitmasking;

import java.util.*;

public class countingBits {
    public static void main(String[] args) {

        System.out.println(Arrays.toString(countingBits_(10)));
        System.out.println(Arrays.toString(countingBits2(10)));
    }

    public static int[] countingBits_(int num) { // time complexity-> O(n log n)
        int[] ans = new int[num + 1];
        int count = 0;
        ans[0] = 0;
        for (int i = 1; i <= num; i++) {
            int result = i;
            while (result > 0) {
                result = result & (result - 1);
                count++;
            }
            ans[i] = count;
            count = 0;
        }
        return ans;
    }

    // dynamic programming logic
    public static int[] countingBits2(int num) { // O(n) approach
        int[] ans = new int[num + 1];
        ans[0] = 0;
        for (int i = 1; i <= num; i++) {
            ans[i] = ans[i >> 1] + (i & 1);
        }
        return ans;
    }
}
