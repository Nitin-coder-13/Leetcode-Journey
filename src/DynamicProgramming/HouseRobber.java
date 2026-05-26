package DynamicProgramming;

import java.util.Arrays;

public class HouseRobber {
    public static void main(String[] args) {
        int[] arr = {2, 1, 1, 2};
        int[] dp1 = new int[arr.length];
        int[] dp2 = new int[arr.length];
        Arrays.fill(dp1, -1);
        Arrays.fill(dp2, -1);
        System.out.println(rob_FD(arr, 0, dp1));
        System.out.println(rob_BD(arr, arr.length - 1, dp2));
        System.out.println(rob_BU(arr));
    }

    // Forward Recursive(Backward Table filling)
    public static int rob_FD(int[] nums, int index, int[] dp) {
        if (index >= nums.length) {
            return 0;
        }
        if (dp[index] != -1) { // yaha aisi value rakha karo jo kabhi dp table ka hissa na ho, is case mai zero isliye nahi rakhe kyuki constraints me likha hua tha ki array mai 0 fill ho skta hai, isliye time limit exceed ho jaata hai
            return dp[index];
        }
        int rob = nums[index] + rob_FD(nums, index + 2, dp); // nums[index]+dp[index+2] mai fill krega
        int dntrob = rob_FD(nums, index + 1, dp); // dp[index+1] mai fill krega
        // Hamara final answer 0th index mai store rhega
        return dp[index] = Math.max(rob, dntrob); // dp[i]=Math.Max(dp[i+2],dp[i+1])
    }

    // Backward Recursive (Forward Table Filling)
    public static int rob_BD(int[] nums, int index, int[] dp) {
        if (index < 0) {
            return 0;
        }
        if (dp[index] != -1) {
            return dp[index];
        }
        int rob = nums[index] + rob_BD(nums, index - 2, dp); // nums[index]+ dp[index-2]
        int dntrob = rob_BD(nums, index - 1, dp); // dp[index-1]
        return dp[index] = Math.max(rob, dntrob); // dp[index]=Math.Max(dp[i-2],dp[i-1])
    }

    // Bottom Up Approach (The Final) :- isme hum recursive call bhi aage se rkhenge and filling bhi , mtlb mixture of forward recursive(for recursion) and backward recursive (for table filling)
    public static int rob_BU(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int[] dp3 = new int[nums.length];
        dp3[0] = nums[0];
        dp3[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp3[i] = Math.max(nums[i] + dp3[i - 2], dp3[i - 1]);
        }
        return dp3[dp3.length - 1];
    }
}
