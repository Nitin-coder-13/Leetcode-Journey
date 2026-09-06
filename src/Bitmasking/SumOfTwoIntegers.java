package Bitmasking;

public class SumOfTwoIntegers {
    public static void main(String[] args) {
        System.out.println(sum_(-10, 4));
    }

    public static int sum_(int a, int b) {
        while (b != 0) {
            int carry = (a & b) << 1;
            a = a ^ b;
            b = carry;
        }
        return a;
    }
}
