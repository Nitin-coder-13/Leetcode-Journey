package Bitmasking;

public class singleNumber {
    public static void main(String[] args) {
        int[] arr={2,3,5,3,2,7,7};
    System.out.println(uniquedigit(arr));
    }

    public static int uniquedigit(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            ans = ans ^ nums[i];
        }
        return ans;
    }
}
