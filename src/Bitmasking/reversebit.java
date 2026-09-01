package Bitmasking;

public class reversebit {
    public static void main(String[] args) {
    System.out.println(reversebit_(43261596));
    }

    public static int reversebit_(int n) {
        int ans = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((mask & n) != 0) {
                ans += 1 << 31 - i;
            }
           mask= mask << 1;
        }
        return ans;
    }
}
