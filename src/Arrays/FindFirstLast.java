package Arrays;

import java.util.*;

public class FindFirstLast {
    public static void main(String[] args) {
        int[] res = search_Range(new int[]{5, 7, 7, 8, 8, 10}, 7);
        int[] arr = {5, 7, 7, 8, 8, 9, 10};
        int target = 11;
        int left = search_Rangeleft(arr, target);
        int right = search_Rangeright(arr, target);
        System.out.println(Arrays.toString(new int[]{left, right}));
        System.out.println(Arrays.toString(res));
    }

    // brute force (linear search)
    public static int[] search_Range(int[] nums, int target) {
        int[] arr = {-1, -1};
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                if (arr[0] == -1) {
                    arr[0] = i;
                } else {
                    arr[1] = i;
                }
            }
        }
        return arr;
    }

    private static int search_Rangeleft(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int index = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                index = mid;
                high = mid - 1; // search more in left subarray for the first occurrence
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return index;
    }

    private static int search_Rangeright(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int index = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                index = mid;
                low= mid + 1; // search more in right subarray for the last occurrence
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return index;
    }

}
