package Arrays;

import java.util.*;

public class CountPrimes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(countPrimes(n));
        System.out.println(countPrimes2(n));
    }

    public static int countPrimes(int n) { // suppose n=10
        int count = 0;
        if (n <= 1) {
            return count;
        }
        int total_length = n - 2;
        for (int i = 2; i < n; i++) {
            for (int j = 2; j * j <= i; j++) {
                if (i % j == 0) { // checking for non-prime numbers
                    count++;
                    break;
                }
            }
        }
        return total_length - count;
    }

    public static int countPrimes2(int n) {
        boolean[] isPrime = new boolean[n];
        for (int i = 0; i < n; i++) {
            isPrime[i] = true; // assuming initially all are prime
        }
        for (int p = 2; p * p < n; p++) {
            if (isPrime[p]) {
                // marking all the multiples of a prime as non-prime
                for (int k = p * p; k < n; k += p) {
                    isPrime[k] = false;
                }
            }
        }
        ArrayList<Integer> primes = new ArrayList<>();
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }
        return primes.size();
    }
}
