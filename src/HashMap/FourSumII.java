package HashMap;

import java.util.*;

public class FourSumII {
    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {-2, -1};
        int[] nums3 = {-1, 2};
        int[] nums4 = {0, 2};
        System.out.println(fourSumCount_1(nums1, nums2, nums3, nums4));
    }

    public static int fourSumCount_1(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int n = nums1.length;
        int sum;
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sum = nums1[i] + nums2[j];
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
        int res;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                res = nums3[i] + nums4[j];
                count += map.getOrDefault(-(res),0);
            }
        }
        return count;
    }
}
