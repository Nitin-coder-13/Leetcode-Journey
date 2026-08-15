package Arrays;

import java.util.*;

public class mergeIntervals {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 3}, {2, 6}, {8, 10}, {15, 18}
        };
        System.out.println(Arrays.deepToString(merge_intervals(arr)));
    }

    public static int[][] merge_intervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> res = new ArrayList<>();
        int[] prev = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= prev[1]) {
                prev[1] = Math.max(prev[1], intervals[i][1]);
            } else {
                res.add(prev);
                prev = intervals[i];
            }
        }
        res.add(prev);
        return res.toArray(new int[res.size()][]);
    }
}
