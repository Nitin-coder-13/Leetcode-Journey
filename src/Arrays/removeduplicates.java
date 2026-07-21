package Arrays;

public class removeduplicates {
    public static void main(String[] args) {
      System.out.println(removeDuplicates_(new int[]{0,0,1,1,1,2,2,3,3,4}));
    }

    public static int removeDuplicates_(int[] nums) {
        int i = 1;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[j - 1]) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;

    }
}

