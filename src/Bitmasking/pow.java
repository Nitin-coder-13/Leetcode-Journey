package Bitmasking;

public class pow {
    public static void main(String[] args) {
        int n = -3;
        double x = 2.10000;
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        System.out.println(power(x, N));
    }

    public static double power(double x, long n) {
        if (n == 0) {
            return 1;
        }
        double half = power(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return x * half * half;
        }
    }
}
