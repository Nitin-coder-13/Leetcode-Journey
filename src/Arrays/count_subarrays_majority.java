package Arrays;

import java.util.*;

public class count_subarrays_majority {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3};
        int target = 2;
        System.out.println(majoritycount(arr, target));
    }

    public static int majoritycount(int[] nums, int target) {

        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = i; j < nums.length; j++) {
                int length = j - i + 1;
                if (nums[j] == target) {
                    count++;
                }
                if (count > length / 2) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
