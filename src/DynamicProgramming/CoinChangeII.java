package DynamicProgramming;

import java.util.*;

public class CoinChangeII {
    public static void main(String[] args) {
        int[] coin = {1, 2, 5};
        int amount = 5;
        // since amount will start from 0 and we need to include amount too, that's why amount+1.
        int[][] dp1 = new int[coin.length][amount + 1];
        int[][] dp2 = new int[coin.length][amount + 1];
        for (int[] arr : dp1) {
            Arrays.fill(arr, -1);
        }
        for (int[] arr : dp2) {
            Arrays.fill(arr, -1);
        }
        System.out.println(coinChange_recursion(amount, coin, 0));
        System.out.println(coinChange_FD(amount, coin, 0, dp1));
        System.out.println(coinChange_BD(amount, coin, coin.length - 1, dp2));
        System.out.println(coinChange_BU(amount, coin));
    }

    public static int coinChange_recursion(int amount, int[] coins, int index) {
        if (amount == 0) {
            return 1;
        }
        if (index == coins.length) { // coin khatam ho gya discard krte krte
            return 0;
        }
        int inclusion = 0;
        int exclusion = 0;
        if (amount >= coins[index]) {
            inclusion = coinChange_recursion(amount - coins[index], coins, index);
        }
        exclusion = coinChange_recursion(amount, coins, index + 1);
        return inclusion + exclusion;
    }

    // Forward Recursive (Backward table filling)
    public static int coinChange_FD(int amount, int[] coins, int index, int[][] dp1) {
        int inclusion = 0;
        int exclusion = 0;
        if (amount == 0) {
            return 1;
        }
        if (index == coins.length) {
            return 0;
        }
        if (dp1[index][amount] != -1) {
            return dp1[index][amount];
        }
        if (amount >= coins[index]) {
            inclusion = coinChange_FD(amount - coins[index], coins, index, dp1);
        }
        exclusion = coinChange_FD(amount, coins, index + 1, dp1);
        return dp1[index][amount] = inclusion + exclusion;
    }

    // Backward Recursive ( Forward Table filling)
    public static int coinChange_BD(int amount, int[] coins, int index, int[][] dp2) {
        int inclusion = 0;
        int exclusion = 0;
        if (amount == 0) {
            return 1;
        }
        if (index < 0) {
            return 0;
        }
        if (dp2[index][amount] != -1) {
            return dp2[index][amount];
        }
        if (amount >= coins[index]) {
            inclusion = coinChange_BD(amount - coins[index], coins, index, dp2);
        }
        exclusion = coinChange_BD(amount, coins, index - 1, dp2);
        return dp2[index][amount] = inclusion + exclusion;
    }

    // Bottom Up Approach (The final one)
    public static int coinChange_BU(int amount, int[] coins) {
        int[][] dp3 = new int[coins.length + 1][amount + 1];
        for (int i = 1; i < dp3.length; i++) {
            dp3[i][0] = 1;
        }
        for (int c = 1; c < dp3.length; c++) {
            for (int am = 1; am < dp3[0].length; am++) {
                int inclusion = 0;
                int exclusion = 0;
                // c-1 since array length is +1.
                if (am >= coins[c - 1]) {
                    inclusion = dp3[c][am - coins[c - 1]];
                }
                exclusion = dp3[c - 1][am];
                dp3[c][am] = inclusion + exclusion;
            }
        }
        return dp3[dp3.length - 1][dp3[0].length - 1];
    }


}
