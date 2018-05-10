package com.cxj.leetcode;

import java.util.Arrays;

public class SuperUglyNumber_313 {
    /**
     * public static boolean isPrime(int n) {
     * boolean isprime = true;
     * for (int j = 2; j <= Math.sqrt(n); j++) {
     * if (n % j == 0) {
     * isprime = false;
     * break;
     * }
     * }
     * if (isprime == true)
     * return true;
     * else
     * return false;
     * <p>
     * }
     */
    /**
     * Time limit exceeded
     * @param n
     * @param primes
     * @return
     */
    public int nthSuperUglyNumber(int n, int[] primes) {
        Arrays.sort(primes);
        int[] ugly = new int[n];
        int k = primes.length;
        int j = 1;
        for (int i = 0; i < n; i++) {
//            System.out.println(i);
            while (j < Math.pow(primes[k - 1],n)) {
                if (isUgly(j, primes)) {
//                    System.out.println(j);
                    ugly[i] = j;
                    j++;
                    break;
                }else
                    j++;

            }
        }
        System.out.println(Arrays.toString(ugly));
        return ugly[n - 1];
    }

    public boolean isUgly(int num, int[] primes) {
        int k = primes.length;
        for (int i = 0; i < k; i++) {
            while (num % primes[i] == 0)
                num /= primes[i];
        }
        if (num == 1)
            return true;
        else
            return false;
    }


    public static void main(String[] args) {
        SuperUglyNumber_313 sun = new SuperUglyNumber_313();
        int[] primes = {2,7,13,19};
        System.out.println(sun.nthSuperUglyNumber(12, primes));
    }
}