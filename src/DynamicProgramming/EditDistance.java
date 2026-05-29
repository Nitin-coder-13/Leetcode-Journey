package DynamicProgramming;

import java.util.*;

public class EditDistance {
    public static void main(String[] args) {
        String s1 = "FOOD";
        String s2 = "MONEY";
        int[][] dp1 = new int[s1.length()][s2.length()];
        int[][] dp2 = new int[s1.length()][s2.length()];
        for (int[] arr : dp1) {
            Arrays.fill(arr, -1);
        }
        for (int[] arr1 : dp2) {
            Arrays.fill(arr1, -1);
        }
        System.out.println(edit_recursion(s1, s2, 0, 0));
        System.out.println(edit_FD(s1, s2, 0, 0, dp1));
        System.out.println(edit_BD(s1, s2, s1.length() - 1, s2.length() - 1, dp2));
        System.out.println(edit_BU(s1, s2));
    }

    // Recursive Approach
    public static int edit_recursion(String s1, String s2, int i, int j) {
        if (i == s1.length()) {
            return s2.length() - j;
        }
        if (j == s2.length()) {
            return s1.length() - i;
        }
        int ans = 0;
        if (s1.charAt(i) == s2.charAt(j)) {
            ans = edit_recursion(s1, s2, i + 1, j + 1);
        } else { // 3 operations
            int delete = edit_recursion(s1, s2, i + 1, j);
            int insert = edit_recursion(s1, s2, i, j + 1);
            int replace = edit_recursion(s1, s2, i + 1, j + 1);
            ans = Math.min(Math.min(delete, insert), replace) + 1;
        }
        return ans;
    }

    // Forward Recursive (Backward Table Filling)
    public static int edit_FD(String s1, String s2, int i, int j, int[][] dp1) {
        if (i == s1.length()) {
            return s2.length() - j;
        }
        if (j == s2.length()) {
            return s1.length() - i;
        }
        if (dp1[i][j] != -1) {
            return dp1[i][j];
        }
        if (s1.charAt(i) == s2.charAt(j)) {
            dp1[i][j] = edit_FD(s1, s2, i + 1, j + 1, dp1); // dp1[i+1][j+1]
        } else {
            int delete = edit_FD(s1, s2, i + 1, j, dp1); // dp1[i+1][j]
            int insert = edit_FD(s1, s2, i, j + 1, dp1); // dp1[i][j+1]
            int replace = edit_FD(s1, s2, i + 1, j + 1, dp1); // dp1[i+1][j+1]
            dp1[i][j] = Math.min(Math.min(delete, insert), replace) + 1; // dp[i][j]
        }
        return dp1[i][j];
    }

    // Backward Recursive (Forward Table filling)
    public static int edit_BD(String s1, String s2, int i, int j, int[][] dp2) {
        if (i < 0) {
            return j + 1;
        }
        if (j < 0) {
            return i + 1;
        }
        if (dp2[i][j] != -1) {
            return dp2[i][j];
        }
        if (s1.charAt(i) == s2.charAt(j)) {
            dp2[i][j] = edit_BD(s1, s2, i - 1, j - 1, dp2); // dp2[i-1][j-1]
        } else {
            int delete = edit_BD(s1, s2, i - 1, j, dp2); // dp2[i-1][j]
            int insert = edit_BD(s1, s2, i, j - 1, dp2); // dp2[i][j-1]
            int replace = edit_BD(s1, s2, i - 1, j - 1, dp2); // dp2[i-1][j-1]
            dp2[i][j] = Math.min(Math.min(delete, insert), replace) + 1; // dp2[i][j]
        }
        return dp2[i][j];
    }

    // Bottom Up Approach
    public static int edit_BU(String s1, String s2) {
        int[][] dp3 = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 1; i < dp3[0].length; i++) { // base case filling of column
            dp3[0][i] = i;
        }
        for (int i = 1; i < dp3.length; i++) { // base case filling of row
            dp3[i][0] = i;
        }
        for (int i = 1; i < dp3.length; i++) {
            for (int j = 1; j < dp3[0].length; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp3[i][j] = dp3[i - 1][j - 1];
                } else {
                    int delete = dp3[i - 1][j];
                    int insert = dp3[i][j - 1];
                    int replace = dp3[i - 1][j - 1];
                    dp3[i][j] = Math.min(Math.min(delete, insert), replace) + 1;
                }
            }
        }
        return dp3[dp3.length - 1][dp3[0].length - 1];
    }
}
