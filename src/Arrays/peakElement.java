package Arrays;

public class peakElement {
    public static void main(String[] args) {
        System.out.println(peak(new int[]{1,1,1,1,1,1}));
    }

    public static int peak(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] > arr[mid + 1]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
