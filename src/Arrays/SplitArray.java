package Arrays;

import java.util.*;

public class SplitArray {
    public static void main(String[] args) {
        System.out.println(split(new int[]{7,2,5,10,8}, 2));
    }

    public static int split(int[] nums, int k) {
        int low = Arrays.stream(nums).max().getAsInt();
        int high = Arrays.stream(nums).sum();
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (isValid(nums, k, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return high;
    }

    private static boolean isValid(int[] nums, int k, int mid) {
        int count = 1;
        int sum = 0;
        for (int num : nums) {
            if (sum + num > mid) {
                count++;
                sum = num;
            } else {
                sum += num;
            }
        }
        return count <= k;
    }
}
