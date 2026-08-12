package Arrays;

import java.util.*;

public class medianofTwoSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        System.out.println(merge(nums1, nums2));
       // System.out.println(median_optimised(nums1, nums2));

    }

    public static double merge(int[] nums1, int[] nums2) {
        int i = 0;
        int j = 0;
        int[] ans = new int[nums1.length + nums2.length];
        int k = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                ans[k] = nums1[i];
                i++;
            } else {
                ans[k] = nums2[j];
                j++;
            }
            k++;
        }
        while (i < nums1.length) {
            ans[k] = nums1[i];
            i++;
            k++;
        }
        while (j < nums2.length) {
            ans[k] = nums2[j];
            j++;
            k++;
        }
        return median2(ans);
        // return median(ans);


    }

    public static double median(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];
        if (n % 2 == 0) {
            double x = nums[(n / 2) - 1];
            double y = nums[((n / 2) + 1) - 1];
            return (x + y) / 2;
        } else {
            return nums[((n + 1) / 2) - 1];
        }
    }

    public static double median2(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];
        int low = 0, high = n - 1;
        int mid = low + (high - low) / 2;
        if (n % 2 == 0) { // even case
            return (double) (nums[mid] + nums[mid + 1]) / 2;
        } else {
            return nums[mid];
        }
    }


}
