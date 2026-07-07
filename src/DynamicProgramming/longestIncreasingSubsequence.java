package DynamicProgramming;

public class longestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] arr = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
        System.out.println(length(arr));
    }

    public static int length(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int len = 1; // length of the dp table
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > dp[len - 1]) {
                dp[len] = nums[i];
                len++;
            } else {
                // Binary Search
                int index = search(dp, 0, len - 1, nums[i]);
                dp[index] = nums[i];
            }
        }
        return len;
    }

    public static int search(int[] dp, int start, int end, int target) {
        int ans = 0;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (dp[mid] >= target) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }
}
