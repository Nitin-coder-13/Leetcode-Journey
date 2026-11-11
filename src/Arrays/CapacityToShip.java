package Arrays;

import java.util.*;

public class CapacityToShip {
    public static void main(String[] args) {
        System.out.println(capacity(new int[]{1,2,3,1,1},4));
    }

    public static int capacity(int[] weights, int days) {
        int low = Arrays.stream(weights).max().getAsInt();
        int sum = 0;
        for (int weight : weights) {
            sum += weight;
        }
        int high = sum;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (valid(weights, days, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return high;
    }

    private static boolean valid(int[] weights, int days, int mid) {
        int count = 1;
        int sum = 0;
        for (int weight : weights) {
            if (sum + weight > mid) {
                count++;
                sum = weight;
            } else {
                sum += weight;
            }
        }
        return count<=days;
    }
}
