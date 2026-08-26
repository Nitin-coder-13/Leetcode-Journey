package Bitmasking;

public class poweroftwo {
    public static void main(String[] args) {

        System.out.println(isPowerOfTwo(6));
    }

    public static boolean isPowerOfTwo(int n) {
        if (n < 0) {
            return false;
        }
        return ((long) n & ((long) n - 1)) == 0;

    }
}
