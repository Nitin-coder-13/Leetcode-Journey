package Bitmasking;

import java.util.Arrays;

public class singleNumberIII {
    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 3, 2, 5};
        System.out.println(Arrays.toString(singleNumber3(arr)));
    }

    public static int[] singleNumber3(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            ans = ans ^ nums[i];
        }
        int mask = (ans & (~(ans - 1)));
        int a = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((mask & nums[i]) != 0) {
                a = a ^ nums[i];
            }
        }
        int b = ans ^ a;
        return new int[]{a, b};
    }
}
