package Arrays;

import java.util.*;

public class MinimizeMaxGasStation {
    public static void main(String[] args) {
         System.out.println(minDistance(new int[]{1,2,3,4,5,6,7,8,9,10},9));
    }

    public static double minDistance(int[] stations, int k) {
        double low = 0.0;
        double maxgap = Integer.MIN_VALUE;
        for (int i = 1; i < stations.length; i++) {
            maxgap = Math.max(maxgap, stations[i] - stations[i - 1]);
        }
        double high = maxgap;
        while (low < high) {
            double mid = low + (high - low) / 2;
            if (isValid(stations, k, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return high;
    }

    private static boolean isValid(int[] stations, int k, double mid) {
        int count = 0;
        for (int i = 1; i < stations.length; i++) {
            double gap = stations[i] - stations[i - 1];
            int required = (int) Math.ceil(gap / mid) - 1;
            count += required;
            if (count > k) {
                return false;
            }
        }
        return true;
    }
}
