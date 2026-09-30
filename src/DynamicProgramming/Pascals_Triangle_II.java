package DynamicProgramming;

import java.util.*;

public class Pascals_Triangle_II {
    public static void main(String[] args) {
        System.out.println(getRow(3));
    }

    public static List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        int[][] dp = new int[rowIndex + 1][rowIndex + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= rowIndex; i++) {
            dp[i][0] = 1;
            dp[i][i] = 1;
            for (int j = 1; j <= i; j++) {
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
            }
        }
        for (int j = 0; j <= rowIndex; j++) {
            result.add(dp[rowIndex][j]);
        }
         return result;
    }
}
