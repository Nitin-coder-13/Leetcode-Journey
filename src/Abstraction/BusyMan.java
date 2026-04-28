package Abstraction;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class BusyMan {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        while (t-- > 0) {
            int n = input.nextInt();
            Pair[] pairs = new Pair[n];
            for (int i = 0; i < pairs.length; i++) {
                int start = input.nextInt();
                int end = input.nextInt();
                pairs[i] = new Pair(start, end);
            }

            Arrays.sort(pairs, new Comparator<Pair>() {
                @Override
                public int compare(Pair o1, Pair o2) {
                    return o1.end - o2.end;
                }
            });
            int count = 1;
            int end = pairs[0].end;
            for (int i = 0; i < pairs.length; i++) {
                if (end <= pairs[i].start) {
                    count++;
                    end = pairs[i].end;

                }
            }
            System.out.println(count);
        }
    }

    public static class Pair {
        int start;
        int end;

        public Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}