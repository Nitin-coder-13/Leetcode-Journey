package DynamicProgramming;

public class MinimumFallingPathSumII {
    public static void main(String[] args) {
        int[][] matrix = {{0, 1000, 1000}, {1000, 1000, 0}, {0, 1000, 1000}};
        int ans = Integer.MAX_VALUE;
        for (int j = 0; j < matrix[0].length; j++) {
            ans = Math.min(ans, minSum(matrix, 0, j));
        }
        System.out.println(ans);
        System.out.println(minSum2(matrix));
    }

    public static int minSum(int[][] grid, int cr, int cc) {
        if (cr == grid.length - 1) {
            return grid[cr][cc];
        }
        int sol = Integer.MAX_VALUE;
        for (int k = 0; k < grid[0].length; k++) {
            if (cc != k) {
                sol = Math.min(sol, minSum(grid, cr + 1, k));
            }
        }
        return sol + grid[cr][cc];
    }

    // BOTTOM UP APPROACH
    public static int minSum2(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] dp = new int[rows][cols];
        for (int j = 0; j < cols; j++) {
            dp[rows - 1][j] = grid[rows - 1][j];
        }
        for (int i = rows - 2; i >= 0; i--) {
            for (int j = 0; j < cols; j++) {
                int sol = Integer.MAX_VALUE;
                for (int k = 0; k < cols; k++) {
                    if (j != k) {
                        sol = Math.min(dp[i + 1][k], sol);
                    }
                }
                dp[i][j] = grid[i][j] + sol;
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int j = 0; j < cols; j++) {
            ans = Math.min(ans, dp[0][j]);
        }
        return ans;
    }


}
