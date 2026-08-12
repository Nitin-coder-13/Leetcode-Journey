package Arrays;

import java.util.Arrays;

public class rotateImage {
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        rotate(arr);
    }

    public static void rotate(int[][] arr) {
        //int[][] res = new int[arr.length][arr[0].length];
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            int start = 0;
            int end = arr.length - 1;
            while (start < end) {
                int temp = arr[i][start];
                arr[i][start] = arr[i][end];
                arr[i][end] = temp;
                start++;
                end--;
            }
        }
        System.out.println(Arrays.deepToString(arr));
    }
}
