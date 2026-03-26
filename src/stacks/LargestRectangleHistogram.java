package Stacks;

import java.util.Stack;

public class LargestRectangleHistogram {
    public static void main(String[] args) {
        int[] heights = {2, 1, 5, 6, 2, 3};
        int result = largestRectangleArea(heights);
        System.out.println(result);

    }

    public static int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int ans = 0;
        for (int i = 0; i < heights.length; i++) {
            while (!st.isEmpty() && heights[i] < heights[st.peek()]) {
                int height = heights[st.pop()];
                int r = i;
                if (st.isEmpty()) {
                    int area = height * r;
                    ans = Math.max(ans, area);
                } else {
                    int left_min = st.peek();
                    int area = height * (r - left_min - 1);
                    ans = Math.max(ans, area);

                }
            }
            st.push(i);
        }
        int r = heights.length;
        while (!st.isEmpty()) {
            int height = heights[st.pop()];
            if (st.isEmpty()) {
                int area = height * r;
                ans = Math.max(ans, area);
            } else {
                int left_min = st.peek();
                int area = height * (r - left_min - 1);
                ans = Math.max(ans, area);
            }
        }
        return ans;

    }
}
