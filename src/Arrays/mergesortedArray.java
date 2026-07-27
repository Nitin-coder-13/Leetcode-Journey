package Arrays;

import java.util.*;

public class mergesortedArray {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = 0;
        int n = 1;
        int[] arr1 = new int[m + n];
        int[] arr2 = new int[n];
        for (int i = 0; i < m + n; i++) {
            arr1[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            arr2[i] = in.nextInt();
        }
        sort_(arr1, m, arr2, n);
        System.out.println(Arrays.toString(arr1));
    }
  // backward filling is the logic here
    public static void sort_(int[] arr1, int m, int[] arr2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (arr1[i] > arr2[j]) {
                arr1[k--] = arr1[i--];
            } else {
                arr1[k--] = arr2[j--];
            }
        }
        while (i >= 0) {
            arr1[k--] = arr1[i--];
        }
        while(j>=0){
            arr1[k--] = arr2[j--];
        }

    }
}