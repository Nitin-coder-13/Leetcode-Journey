package Arrays;

public class missingno {
    public static void main(String[] args) {
       System.out.println(missing_number(new int[]{0,1,3}));
    }

    public static int missing_number(int[] arr) {
        int n = arr.length;
        int expected_sum = 0;
        int actual_sum = 0;
        for (int i = 0; i < n; i++) {
            actual_sum += arr[i];
            expected_sum += i;
        }
        expected_sum += n;
        return expected_sum - actual_sum;
    }
}
