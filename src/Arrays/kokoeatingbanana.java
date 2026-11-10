package Arrays;

import java.util.*;

public class kokoeatingbanana {
    public static void main(String[] args) {
        System.out.println(speed_search(new int[]{3, 6, 7, 11}, 8));
        System.out.println(time_search(new int[]{3, 6, 7, 11}, 8));
    }

    // brute force linear search approach
    public static int speed_search(int[] arr, int h) {
        int min_speed = 1;
        int max_speed = Arrays.stream(arr).max().getAsInt();
        for (int i = min_speed; i <= max_speed; i++) {
            long required_time = requiredtime(arr, i);
            if (required_time <= h) {
                return i;
            }
        }
        return -1;
    }

    public static long requiredtime(int[] arr, int k) {
        long total_hours = 0;
        for (int i = 0; i < arr.length; i++) {
            total_hours += (long) Math.ceil((double) arr[i] / k);
        }
        return total_hours;
    }
  // binary search approach
    public static int time_search(int[] arr, int h) {
        int min_time = 1;
        int max_time = Arrays.stream(arr).max().getAsInt();
        while (min_time <= max_time) {
            int mid = min_time + (max_time - min_time) / 2;
            if (isitpossible(arr, mid, h)) {
                max_time = mid - 1;
            } else {
                min_time = mid + 1;
            }
        }
        return min_time;
    }

    public static boolean isitpossible(int[] arr, int k, int h) {
        long total_hours = 0;
        for (int j : arr) {
            total_hours += (long) Math.ceil((double) j / k);
        }
        return total_hours <= h;
    }
}



