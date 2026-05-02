package Arrays;

import Map.Set;

import java.util.Arrays;
import java.util.HashSet;

public class IntersectionArrays {
    public static void main(String[] args) {
        int[] nums1 = {4,9,5};
        int[] nums2 = {9,4,9,8,4};
        System.out.println(Arrays.toString(intersect(nums1, nums2)));
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> resultset = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set1.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            if (set1.contains(nums2[i])) {
                resultset.add(nums2[i]);
            }
        }
        int[] result = new int[resultset.size()];
        int i = 0;
        for (int n : resultset) {
            result[i++] = n;
        }
        return result;

    }

}
