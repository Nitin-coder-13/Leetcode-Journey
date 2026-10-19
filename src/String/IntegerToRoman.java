package String;

import java.util.*;

public class IntegerToRoman {
    public static void main(String[] args) {
      System.out.println(Roman(3749));
    }

    public static String Roman(int num) {
        // mapping all the known roman numbers to us to their respective integers
        String[] units = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        String[] tens = {"", "X", "XX", "xxx", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] hundreds = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] thousands = {"", "M", "MM", "MMM"};
        // just map the values
        return thousands[num / 1000] +
                hundreds[(num % 1000) / 100] +
                tens[(num % 100) / 10] +
                units[num % 10];

    }
}
