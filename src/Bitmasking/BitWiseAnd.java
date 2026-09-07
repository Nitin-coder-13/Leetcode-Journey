package Bitmasking;

public class BitWiseAnd {
    public static void main(String[] args) {
        System.out.println(range_(2, 7));
        System.out.println(range(1, 2147483647));
    }

    public static int range_(int left, int right) {
        // brute force
        int ans = 0;
        ans = ans ^ left;
        for (int i = left + 1; i <= right; i++) {
            ans = ans & i;
        }
        return ans;
    }

    public static int range(int left, int right) {
        while (right > left) {
            right = right & (right - 1);
        }
        return right;
    }
}
