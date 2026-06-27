package DynamicProgramming;

public class MinimumPathSum {
    public static void main(String[] args) {
        int[][] grid = {{1, 2, 3}, {4, 5, 6}};
        System.out.println(minpath(grid, 0, 0));
        System.out.println(minpath2(grid));
    }

    public static int minpath(int[][] grid, int cr, int cc) {
        if (cr == grid.length - 1 && cc == grid[0].length - 1) {
            return grid[cr][cc]; // reached last cell
        }
        if (cr >= grid.length || cc >= grid[0].length) {
            return Integer.MAX_VALUE;
        }

        int down = minpath(grid, cr + 1, cc);
        int right = minpath(grid, cr, cc + 1);
        return Math.min(down, right) + grid[cr][cc];
    }

    // Bottom up approach
    public static int minpath2(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] dp = new int[grid.length][grid[0].length];
        // the base case ( reached end of matrix)
        dp[rows - 1][cols - 1] = grid[rows - 1][cols - 1];
        // for array out of bound cases
        // 1) last columns bharna hai
        for (int i = rows - 2; i >= 0; i--) {
            dp[i][cols - 1] = grid[i][cols - 1] + dp[i + 1][cols - 1];
        }
        // 2) last rows bharna hai
        for (int j = cols - 2; j >= 0; j--) {
            dp[rows - 1][j] = grid[rows - 1][j] + dp[rows - 1][j + 1];
        }
        // rest done normally
        for (int i = rows - 2; i >= 0; i--) {
            for (int j = cols - 2; j >= 0; j--) {
                dp[i][j] = grid[i][j] + Math.min(dp[i + 1][j], dp[i][j + 1]);
            }
        }

        return dp[0][0];
    }

}
