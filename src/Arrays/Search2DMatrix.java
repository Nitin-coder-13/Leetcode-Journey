package Arrays;

public class Search2DMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        int target = 7;
        System.out.println(searchMatrix(matrix, target));
        System.out.println(searchMatrix2(matrix, target));
    }

    // brute force
    public static boolean searchMatrix(int[][] matrix, int target) {
        int i = 0;
        while (i < matrix.length) {
            int low = 0;
            int high = matrix[0].length - 1;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (matrix[i][mid] == target) {
                    return true;
                } else if (matrix[i][mid] >= target) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            i++;
        }
        return false;
    }

    public static boolean searchMatrix2(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        int low = 0;
        int high = (row * col) - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int row_idx = mid / col;
            int col_idx = mid % col;
            if (matrix[row_idx][col_idx] == target) {
                return true;
            } else if (matrix[row_idx][col_idx] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }
}
