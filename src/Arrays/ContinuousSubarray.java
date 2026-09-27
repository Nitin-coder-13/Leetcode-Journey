package Arrays;

import java.util.HashMap;

public class ContinuousSubarray {
    public static void main(String[] args) {
        System.out.println(subarray(new int[]{23, 2, 6, 4, 7}, 6));
        System.out.println(SubarraySum3(new int[]{23, 2, 6, 4, 7}, 6));

    }

    public static boolean subarray(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                boolean ans = checkSubarray(nums, i, j, k);
                if (ans) {
                    return true;
                }
            }
        }
        return false;
    }


    public static boolean checkSubarray(int[] nums, int i, int j, int k) {
        int sum = 0;
        for (int start = i; start <= j; start++) {
            sum += nums[start];
        }
        if (sum == k || sum % k == 0) {
            return true;
        }
        return false;
    }

    public static boolean SubarraySum3(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum % k)) {
                int oldindex = map.get(sum % k);
                if (i - oldindex >= 2) {
                    return true;
                }
            } else {
                map.put(sum % k, i);
            }
        }
        return false;
    }
}

