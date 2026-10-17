package Arrays;

import java.util.*;

public class TrailingZeroes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        //   int fact = factorial(n);
        // System.out.println(trailingZeroes(fact));
        System.out.println(trailingZeroes_(n));

    }

    public static int factorial(int n) {
        if (n == 1 || n == 0) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    public static int trailingZeroes(int n) {
        String str = Integer.toString(n);
        int count = 0;
        int i = str.length() - 1;
        while (i >= 0 && str.charAt(i) == '0') {
            count++;
            i--;
        }
        return count;
    }
    // optimised approach
    public static int trailingZeroes_(int n) {
        int result = 0;
        while (n > 0) {
            result = (int) (result + Math.floor(n / 5));
            n = n / 5;
        }
        return result;
    }
}