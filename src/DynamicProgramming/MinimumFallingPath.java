package DynamicProgramming;

public class MinimumFallingPath {
    public static void main(String[] args) {
        int[][] matrix = {{2, 1, 3}, {6, 5, 4}, {7, 8, 9}};
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            ans = Math.min(ans, minfallpath(matrix, 0, i));
        }
        System.out.println(ans);
        System.out.println(min_fallpath(matrix));
    }

    public static int minfallpath(int[][] matrix, int cr, int cc) {
        if (cc < 0 || cc >= matrix[0].length) {
            return Integer.MAX_VALUE;
        }

        if (cr == matrix.length - 1) {
            return matrix[cr][cc];
        }
        int down = minfallpath(matrix, cr + 1, cc);
        int dg_left = minfallpath(matrix, cr + 1, cc - 1);
        int dg_right = minfallpath(matrix, cr + 1, cc + 1);
        return Math.min(Math.min(dg_left, dg_right), down) + matrix[cr][cc];
    }

    // Bottom Up approach
    public static int min_fallpath(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] dp = new int[rows][cols];
        // base case
        for (int i = cols - 1; i >= 0; i--) {
            dp[rows - 1][i] = matrix[rows - 1][i];
        }
        // rest all
        for (int i = rows - 2; i >= 0; i--) {
            for (int j = cols - 1; j >= 0; j--) {
                int down = dp[i + 1][j];
                int dg_left = (j - 1 >= 0) ? dp[i + 1][j - 1] : Integer.MAX_VALUE;
                int dg_right = (j + 1 < cols) ? dp[i + 1][j + 1] : Integer.MAX_VALUE;
                dp[i][j] = Math.min(Math.min(dg_left, dg_right), down) + matrix[i][j];
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int j = 0; j < cols; j++) {
            ans = Math.min(ans, dp[0][j]);
        }
        return ans;
    }
}

