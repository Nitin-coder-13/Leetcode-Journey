package Arrays;

import java.util.*;

public class meetingRoomsII {
    public static void main(String[] args) {
        int[] start = {10, 22, 11, 4, 11};
        int[] end = {14, 29, 30, 12, 29};
        System.out.println(rooms(start, end));
    }

    public static int rooms(int[] start, int[] end) {
        int n = Math.min(start.length, end.length);
        int[][] meetings = new int[n][2];
        for (int i = 0; i < n; i++) {
            meetings[i][0] = start[i];
            meetings[i][1] = end[i];
        }
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            if (pq.isEmpty()) {
                // first meeting
                pq.add(meetings[i][1]);
            } else {
                if (pq.peek() > meetings[i][0]) {
                    pq.add(meetings[i][1]); // new room created
                } else {
                    pq.remove();
                    pq.add(meetings[i][1]); // old room has been used
                }
            }
        }
        return pq.size();
    }
}
