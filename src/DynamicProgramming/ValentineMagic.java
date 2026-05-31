package DynamicProgramming;

import java.util.*;

public class ValentineMagic {
    public static void main(String[] args) {
        int[] boys = {2, 11, 3};
        int[] girls = {5, 7, 3, 2};
        Arrays.sort(boys);
        Arrays.sort(girls);
        System.out.println(ValentineMagic_recursion(boys, girls, 0, 0));
        System.out.println(ValentineMagic_BU(boys,girls));
    }

    public static int ValentineMagic_recursion(int[] boys, int[] girls, int i, int j) {
        if (i == boys.length) {
            return 0;
        }
        if (j == girls.length) {
            return 10000000;
        }
        int inclusion = 0;
        int exclusion = 0;
        inclusion = Math.abs(boys[i] - girls[j]) + ValentineMagic_recursion(boys, girls, i + 1, j + 1);
        exclusion = ValentineMagic_recursion(boys, girls, i, j + 1);
        return Math.min(inclusion, exclusion);
    }

    public static int ValentineMagic_BU(int[] boys, int[] girls) {
        int[][] dp = new int[boys.length + 1][girls.length + 1];
        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = 10000000;
        }
        for (int boy = 1; boy < dp.length; boy++) {
            for (int girl = 1; girl < dp[0].length; girl++) {
                int inclusion = 0;
                int exclusion = 0;
                inclusion = Math.abs(boys[boy - 1] - girls[girl - 1]) + dp[boy - 1][girl - 1];
                exclusion = dp[boy][girl - 1];
                dp[boy][girl] = Math.min(inclusion, exclusion);
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }

}
