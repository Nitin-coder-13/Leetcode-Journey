package Bitmasking;

public class HammingDistance {
    public static void main(String[] args) {
    System.out.println(hammingDistance(3,1));
    }

    public static int hammingDistance(int x, int y) {
        int n = x ^ y;
        int count=0;
        while (n != 0) {
            n=n&(n-1);
            count++;
        }
        return count;
    }
}
