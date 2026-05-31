package DynamicProgramming;

public class DistinctSubsequences {
    public static void main(String[] args) {
        String s = "rabbbit";
        String t = "rabbit";
        System.out.println(numDistinct_recursion(s, t, 0, 0));
        System.out.println(numDistinct_BU(s, t));
    }

    public static int numDistinct_recursion(String s, String t, int i, int j) {
        if (t.length() == j) {
            return 1;
        }
        if (s.length() == i) {
            return 0;
        }
        int inclusion = 0;
        int exclusion = 0;
        if (s.charAt(i) == t.charAt(j)) {
            inclusion = numDistinct_recursion(s, t, i + 1, j + 1);
        }
        exclusion = numDistinct_recursion(s, t, i + 1, j);
        return inclusion + exclusion;
    }

    public static int numDistinct_BU(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }
        for (int cs = 1; cs < dp.length; cs++) { // coin string
            for (int ams = 1; ams < dp[0].length; ams++) { // amount string
                int inclusion = 0;
                int exclusion = 0;
                if (s.charAt(cs - 1) == t.charAt(ams - 1)) {
                    inclusion = dp[cs - 1][ams - 1];
                }
                exclusion = dp[cs - 1][ams];
                dp[cs][ams] = inclusion + exclusion;
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }
}

