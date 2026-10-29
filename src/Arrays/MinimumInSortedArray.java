package Arrays;

public class MinimumInSortedArray {
    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(bs(nums));
    }

    public static int bs(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > nums[high]) {
                low = mid + 1;
            } else if (nums[mid]<=nums[high]){
                high=mid;
            }
        }
        return nums[low]; // low or high both will converge at same point so anyone can be returned
    }
}
