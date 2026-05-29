package DynamicProgramming;

import java.util.*;

public class LCS {
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "abc";
        int[][] dp1 = new int[s1.length()][s2.length()];
        int[][] dp2 = new int[s1.length()][s2.length()];
        for (int[] arr : dp1) {
            Arrays.fill(arr, -1);
        }
        for (int[] arr1 : dp2) {
            Arrays.fill(arr1, -1);
        }
        System.out.println(lcs_recursion(s1, s2, 0, 0));
        System.out.println(lcs_FD(s1, s2, 0, 0, dp1));
        System.out.println(lcs_BD(s1, s2, s1.length() - 1, s2.length() - 1, dp2));
        System.out.println(lcs_BU(s1, s2));
    }

    public static int lcs_recursion(String s1, String s2, int i, int j) {
        int ans = 0;
        if (i == s1.length() || j == s2.length()) {
            return 0;
        }
        if (s1.charAt(i) == s2.charAt(j)) {
            ans = 1 + lcs_recursion(s1, s2, i + 1, j + 1);
        } else {
            int a = lcs_recursion(s1, s2, i + 1, j);
            int b = lcs_recursion(s1, s2, i, j + 1);
            ans = Math.max(a, b);
        }
        return ans;
    }

    // Forward Recursive Call (Backward Table Filling)
    public static int lcs_FD(String s1, String s2, int i, int j, int[][] dp1) {
        if (i == s1.length() || j == s2.length()) {
            return 0;
        }
        if (dp1[i][j] != -1) {
            return dp1[i][j];
        }
        if (s1.charAt(i) == s2.charAt(j)) {
            dp1[i][j] = 1 + lcs_FD(s1, s2, i + 1, j + 1, dp1); //  dp1[i+1][j+1] (recursive call ka answer yaad)
        } else {
            int c = lcs_FD(s1, s2, i + 1, j, dp1); // dp1[i+1][j]
            int d = lcs_FD(s1, s2, i, j + 1, dp1); // dp1[i][j+1]
            dp1[i][j] = Math.max(c, d);
        }
        return dp1[i][j];
    }

    // Backward Recursive Call(Forward Table Filling)
    public static int lcs_BD(String s1, String s2, int i, int j, int[][] dp2) {
        if (i < 0 || j < 0) {
            return 0;
        }
        if (dp2[i][j] != -1) {
            return dp2[i][j];
        }
        if (s1.charAt(i) == s2.charAt(j)) {
            dp2[i][j] = 1 + lcs_BD(s1, s2, i - 1, j - 1, dp2);// dp2[i-1][j-1]
        } else {
            int e = lcs_BD(s1, s2, i - 1, j, dp2); // dp2[i-1][j]
            int f = lcs_BD(s1, s2, i, j - 1, dp2); // dp2[i][j-1]
            dp2[i][j] = Math.max(e, f);
        }
        return dp2[i][j];
    }

    // Bottom Up Approach (Forward Recursive + Forward Table Filling)
    public static int lcs_BU(String s1, String s2) {
        int[][] dp3 = new int[s1.length() + 1][s2.length() + 1]; // 1 length jaada ka due to base(blank)case thing
        for (int i = 1; i < dp3.length; i++) {
            for (int j = 1; j < dp3[i].length; j++) {
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp3[i][j]=1+dp3[i-1][j-1];
                }else{
                    int a=dp3[i-1][j];
                    int b=dp3[i][j-1];
                    dp3[i][j]=Math.max(a,b);
                }
            }
        }
        return dp3[dp3.length-1][dp3[0].length-1];
    }
}
