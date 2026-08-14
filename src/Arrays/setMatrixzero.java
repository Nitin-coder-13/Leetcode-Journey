package Arrays;

import java.util.Arrays;

public class setMatrixzero {
    public static void main(String[] args) {
        int[][] arr = {{1,0}};
        int[][] arr1 = {{1,0}};
        int[][] arr2 = {{1,0}};
        setMatrixzero_(arr);
        setMatrixzero2(arr1);
        setMatrixzero3(arr2);
    }

    public static void setMatrixzero_(int[][] arr) {
        // brute force
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == 0) {
                    markrow(arr, i);
                    markcol(arr, j);
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == -1) {
                    arr[i][j] = 0;
                }
            }
        }
        System.out.println(Arrays.deepToString(arr));
    }

    public static void markrow(int[][] arr, int i) {
        for (int j = 0; j < arr[0].length; j++) {
            if (arr[i][j] != 0) {
                arr[i][j] = -1;
            }
        }
    }

    public static void markcol(int[][] arr, int j) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i][j] != 0) {
                arr[i][j] = -1;
            }
        }
    }

    public static void setMatrixzero2(int[][] arr) {
        // better approach
        int[] row = new int[arr.length];
        int[] col = new int[arr[0].length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == 0) {
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (row[i] == 1 || col[j] == 1) {
                    arr[i][j] = 0;
                }
            }
        }
        System.out.println(Arrays.deepToString(arr));
    }

    public static void setMatrixzero3(int[][] matrix) {
        // optimal solution (in-place)
        // int[] row=new int[arr.length];----> matrix[...][0]
        // int[] col=new int[arr[0].length];---> matrix[0][...]
        int col0 = 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    // mark the ith row and jth column
                    matrix[i][0] = 0;
                    if (j != 0) {
                        matrix[0][j] = 0;
                    } else {
                        col0 = 0;
                    }
                }
            }
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] != 0) {
                    // check for col and row
                    if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                        matrix[i][j] = 0;
                    }
                }
            }
        }
        if (matrix[0][0] == 0) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[0][j] = 0;
            }
        }
        if (col0 == 0) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
        System.out.println(Arrays.deepToString(matrix));
    }
}
