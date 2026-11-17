package Recursion;

import java.util.*;

public class Subsets {
    public static void main(String[] args) {
        ArrayList<Integer> set = new ArrayList<>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        subset(new int[]{1, 2, 3, 4}, 0, set, result);
        System.out.println(result);
    }

    public static void subset(int[] nums, int index, ArrayList<Integer> set, ArrayList<ArrayList<Integer>> result) {
        if (index == nums.length) {
            result.add(new ArrayList<>(set));
            return;
        }
        // choice 1:- include kro
        set.add(nums[index]);
        subset(nums, index + 1, set, result);

        // undo the changes to explore more possibilities
        set.remove(set.size() - 1);

        // choice 2: exclude kro
        subset(nums, index + 1, set, result);

    }
}
