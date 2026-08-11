package Arrays;

import java.util.ArrayList;
import java.util.List;

public class spiralMatrix {
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        System.out.println(spiralOrder_(arr));
    }

    public static List<Integer> spiralOrder_(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int total_elements = matrix.length * matrix[0].length;
        int min_row = 0;
        int max_row = matrix.length - 1;
        int min_col = 0;
        int max_col = matrix[0].length - 1;
        int count = 0;
        while (count < total_elements) {
            for (int i = min_col; i <= max_col && count < total_elements; i++) {
                res.add(matrix[min_row][i]);
                count++;
            }
            min_row++;
            for (int i = min_row; i <= max_row && count < total_elements; i++) {
                res.add(matrix[i][max_col]);
                count++;
            }
            max_col--;
            for (int i = max_col; i >= min_col && count < total_elements; i--) {
                res.add(matrix[max_row][i]);
                count++;
            }
            max_row--;
            for (int i = max_row; i >= min_row && count < total_elements; i--) {
                res.add(matrix[i][min_col]);
                count++;
            }
            min_col++;
        }
        return res;

    }
}
