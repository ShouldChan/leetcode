package com.cxj.onlinetest;

/**
 * 自己实现排列组合的方法
 * 最简单的根据数学计算公式
 * C(n,m)=A(n,m)/m!
 * A(n,m)=n!/(n-m)!
 */

public class PermutationAndCombination {
    public static long getFactorialN(int n) {
        if (n == 0)
            return 1;
        return n * getFactorialN(n - 1);
    }

    public static long loopFactorialN(int n) {
        long result = 1;
        for (int i = n; i >= 1; i--) {
            result *= i;
        }
        return result;
    }

    public static long permutation(int n, int m) {
        return (long) (loopFactorialN(n) / loopFactorialN(n - m));
    }

    public static long combination(int n, int m) {
        return (long) (permutation(n, m) / loopFactorialN(m));
    }

    public static void main(String[] args) {
//        System.out.println(getFactorialN(5));
//        System.out.println(loopFactorialN(5));
        System.out.println(permutation(5, 3));
        System.out.println(combination(5, 3));
    }
}