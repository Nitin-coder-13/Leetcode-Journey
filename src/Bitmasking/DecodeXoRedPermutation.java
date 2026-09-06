package Bitmasking;

import java.util.*;

public class DecodeXoRedPermutation {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(decode(new int[]{3,1})));
    }

    public static int[] decode(int[] encoded) {
        int n = encoded.length+1;
        int x = 0;
        int[] ans = new int[n];
        int encode = 0;
        for (int i = 1; i <= n; i++) {
            x = x ^ i;
        }
        for (int i = 1; i < n; i += 2) {
            encode = encode ^ encoded[i];
        }
        ans[0] = x ^ encode;
        for (int i = 1; i < n; i++) {
            ans[i] = ans[i - 1] ^ encoded[i-1];
        }
        return ans;

    }
}
