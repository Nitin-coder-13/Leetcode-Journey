package Arrays;

import java.util.Arrays;

public class moveZeroes {
    public static void main(String[] args) {
        int[] arr = {0,1,0,3,12};
        move(arr);
        move_(arr);
    }

    public static void move(int[] nums) {
        int[] ans = new int[nums.length];
        int i = 0, j = 0;
        while (i < nums.length) {
            if (nums[i] != 0) {
                ans[j] = nums[i];
                j++;
                i++;
            } else {
                i++;
            }
        }
        System.out.println(Arrays.toString(ans));
    }

    public static void move_(int[] nums) {
        int i = 0, j = 0;
        int temp;
        while (i < nums.length) {
            if (nums[i] != 0) {
                temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
                i++;
            }else{
                i++;
            }
        }
        System.out.println(Arrays.toString(nums));
    }
}
