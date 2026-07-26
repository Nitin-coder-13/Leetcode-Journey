package Arrays;

public class containerwithMostWater {
    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
        System.out.println(maxArea2(new int[]{1,8,6,2,5,4,8,3,7}));
    }

    // brute force:- but tle de dega
    public static int maxArea(int[] height) {
        int ans = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                if (height[i] > height[j]) {
                    ans = Math.max(ans, (j - i) * height[j]);
                } else if (height[i] < height[j]) {
                    ans = Math.max(ans, (j - i) * height[i]);
                } else {
                    ans = Math.max(ans, (j - i) * height[i]);
                }
            }
        }
        return ans;
    }
 // optimal approach
    public static int maxArea2(int[] height) {
        int ans = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            if (height[left] < height[right]) {
                ans = Math.max(ans, height[left] * (right - left));
                left++;
            } else if (height[left] > height[right]) {
                ans = Math.max(ans, height[right] * (right - left));
                right--;
            } else {
                ans = Math.max(ans, height[left] * (right - left));
                left++;
            }
        }
        return ans;
    }
}
