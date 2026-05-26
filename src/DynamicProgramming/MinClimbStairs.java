package DynamicProgramming;

import java.util.*;

public class MinClimbStairs {
    public static void main(String[] args) {
        int[] arr = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        int[] dp1 = new int[arr.length];
        int[] dp2 = new int[arr.length];
        Arrays.fill(dp1, -1);
        Arrays.fill(dp2, -1);
        System.out.println(climb_FD(arr, dp1, 0));
        System.out.println(climb_BD(arr, dp2, arr.length - 1));
        System.out.println(climb_BU(arr));
    }

    // Forward recursive call (Backward table filling)
    public static int climb_FD(int[] cost, int[] dp1, int index) {
        if (index >= cost.length) {
            return 0;
        }
        if (dp1[index] != -1) {
            return dp1[index];
        }
        int first_index = climb_FD(cost, dp1, index + 1); // dp1[index+1]
        int second_index = climb_FD(cost, dp1, index + 2); // dp1[index+2]
        return dp1[index] = Math.min(first_index, second_index) + cost[index]; // dp1[index]=Math.min(dp1[index+1],dp1[index+2])+cost[index]
    }

    // Backward recursive call (Forward table filling)
    public static int climb_BD(int[] cost, int[] dp1, int index) {
        if (index < 0) {
            return 0;
        }
        if (dp1[index] != -1) {
            return dp1[index];
        }
        int first_index = climb_BD(cost, dp1, index - 1); // dp2[index-1]
        int second_index = climb_BD(cost, dp1, index - 2); // dp2[index-2]
        return dp1[index] = Math.min(first_index, second_index) + cost[index]; // dp2[index]=Math.min(dp2[index-1],dp2[index-2])+cost[index]
    }

    // Bottom Up Approach (Forward Recusrive call + Forward Table Filling)
    public static int climb_BU(int[] cost) {
        int[] dp3 = new int[cost.length];
        dp3[0] = cost[0];
        dp3[1] = cost[1];
        for (int i = 2; i < cost.length; i++) {
            dp3[i] = Math.min(dp3[i - 1], dp3[i - 2]) + cost[i];
        }
        return Math.min(dp3[dp3.length - 1], dp3[dp3.length - 2]);
    }

}
