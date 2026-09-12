package Bitmasking;

import java.util.*;

public class UTF8Validation {
    public static void main(String[] args) {
        System.out.println(isValidUTF8(new int[]{197, 130, 1}));
        System.out.println(isValidUTF8(new int[]{197, 130, 1}));
    }

    // using right shifts
    public static boolean isValidUTF8(int[] data) {
        int remaining_bytes = 0;
        for (int num : data) {
            if (remaining_bytes == 0) {
                if ((num >> 7) == 0b0) {
                    remaining_bytes = 0;
                } else if ((num >> 5) == 0b110) {
                    remaining_bytes = 1;
                } else if ((num >> 4) == 0b1110) {
                    remaining_bytes = 2;
                } else if ((num >> 3) == 0b11110) {
                    remaining_bytes = 3;
                } else {
                    // invalid starting byte
                    return false;

                }
            } else {
                if ((num >> 6) == 0b10) {
                    remaining_bytes--;
                } else {
                    return false;
                }
            }
        }
        return remaining_bytes == 0;
    }

    // using left shifts(bit masks)
    public static boolean isValidUTF8_2(int[] data) {
        int remaining_bytes = 0;
        int mask1 = 1 << 7;
        int mask2 = 1 << 6;
        for (int num : data) {
            if (remaining_bytes == 0) {
                int mask = 1 << 7;
                while ((num & mask) != 0) {
                    remaining_bytes++; // count the whole bytes;
                    mask = mask >> 1;
                }
                if (remaining_bytes == 0) {
                    continue;
                }
                if (remaining_bytes == 1 || remaining_bytes > 4) { // it means illegal starting like '10' or it greater than 4 bytes long
                    return false;
                }
                remaining_bytes--; // subtract the current byte since it is the first one
            } else {
                if (!((num & mask1) != 0 && (num & mask2) == 0)) {
                    return false;
                }
                remaining_bytes--;
            }
        }
        return remaining_bytes == 0;
    }
}
