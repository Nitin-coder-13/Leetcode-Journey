package Arrays;

import java.util.Arrays;

public class sortColors {
    public static void main(String[] args) {
        int[] arr = {2, 0, 2, 1, 1, 0};
        sort_colors(arr);
        sorting(arr);
    }

    public static void sort_colors(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    // DUTCH NATIONAL FLAG ALGO
    public static void sorting(int[] arr) {
        int low = 0;
        int mid = 0;
        int high = arr.length - 1;
        while (mid <= high) {
            if(arr[mid]==0){
                int temp = arr[low];
                arr[low] = arr[mid];
                arr[mid] = temp;
                low++;
                mid++;
            }else if(arr[mid]==1){
                mid++;
            }else{
                int temp = arr[mid];
                arr[mid] = arr[high];
                arr[high] = temp;
                high--;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
