package DynamicProgramming;

public class knapSack {
    public static void main(String[] args) {
        int[] wt = {4, 5, 1};
        int[] val = {1, 2, 3};
        int cap = 3;
        System.out.println(knapSack_recursion(wt, val, cap, 0));
        System.out.println(knapSack_BU(wt, val, cap));

    }

    public static int knapSack_recursion(int[] wt, int[] val, int cap, int i) {
        if (i == wt.length || cap == 0) {
            return 0;
        }
        int inclusion = 0;
        int exclusion = 0;
        if (cap >= wt[i]) {
            inclusion = val[i] + knapSack_recursion(wt, val, cap - wt[i], i + 1);
        }
        exclusion = knapSack_recursion(wt, val, cap, i + 1);
        return Math.max(inclusion, exclusion);
    }

    public static int knapSack_BU(int[] wt, int[] val, int cap) {
        int[][] dp = new int[wt.length + 1][cap + 1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                int inclusion = 0;
                int exclusion = 0;
                if (j >= wt[i - 1]) {
                    inclusion = val[i - 1] + dp[i - 1][j - wt[i - 1]];
                }
                exclusion = dp[i - 1][j];
                dp[i][j] = Math.max(inclusion, exclusion);
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }
}
