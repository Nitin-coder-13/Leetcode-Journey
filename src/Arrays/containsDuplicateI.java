package Arrays;

import java.util.HashMap;
import java.util.HashSet;

public class containsDuplicateI {
    public static void main(String[] args) {
        System.out.println(search(new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2}));
        System.out.println(search2(new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2}));
    }

    public static boolean search(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int freq = 1;
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], freq);
            } else {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
        }
        for (int key : map.keySet()) {
            if (map.get(key) > freq) {
                return true;
            }
        }
        return false;
    }

    public static boolean search2(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int x : nums) {
            if (set.contains(x)) {
                return true;
            }
            set.add(x);
        }
        return false;
    }
}

