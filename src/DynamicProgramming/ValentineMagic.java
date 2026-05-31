package DynamicProgramming;

import java.util.*;

public class ValentineMagic {
    public static void main(String[] args) {
        int[] boys = {2, 11, 3};
        int[] girls = {5, 7, 3, 2};
        Arrays.sort(boys);
        Arrays.sort(girls);
        System.out.println(ValentineMagic_recursion(boys, girls, 0, 0));
    }

    public static int ValentineMagic_recursion(int[] boys, int[] girls, int i, int j) {
        if (i == boys.length) {
            return 0;
        }
        if (j == girls.length) {
            return 10000000;
        }
        int inclusion = 0;
        int exclusion = 0;
        inclusion = Math.abs(boys[i] - girls[j]) + ValentineMagic_recursion(boys, girls, i + 1, j + 1);
        exclusion = ValentineMagic_recursion(boys, girls, i, j + 1);
        return Math.min(inclusion, exclusion);
    }

}
