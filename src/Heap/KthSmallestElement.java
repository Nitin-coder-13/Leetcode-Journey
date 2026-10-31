package Heap;

import java.util.*;

public class KthSmallestElement {
    public static void main(String[] args) {
        int[][] arr = {{1, 2}, {1, 3}};
        int k = 2;
        System.out.println(smallestNumber_(arr, k));
        System.out.println(smallestNumber2(arr, k));
    }

    // brute force using maxheap
    public static int smallestNumber_(int[][] matrix, int k) {
        PriorityQueue<Integer> maxheap = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                maxheap.add(matrix[i][j]);
                if (maxheap.size() > k) {
                    maxheap.poll();
                }
            }
        }
        return maxheap.poll();
    }

    public static int smallestNumber2(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        int low = matrix[0][0];
        int ans = -1;
        int high = matrix[m - 1][n - 1];
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int count = countOfSmallerOrEqualElements(matrix, mid);
            if (count >= k) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    private static int countOfSmallerOrEqualElements(int[][] matrix, int mid) {
        int count = 0;
        for (int i = 0; i < matrix.length; i++) {
            int low = 0;
            int high = matrix[0].length-1;
            while (low <= high) {
                int value = low + (high - low) / 2;
                if (matrix[i][value] <= mid) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            count += low;
        }
        return count;
    }
}
