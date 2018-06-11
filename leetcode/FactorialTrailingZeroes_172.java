package com.cxj.leetcode;

public class FactorialTrailingZeroes_172 {
    public int trailingZeroes(int n) {
        return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);

    }

    public int fun(int n) {
        if (n == 1)
            return 1;
        return n * fun(n - 1);
    }

    public static void main(String[] args) {
        FactorialTrailingZeroes_172 ft = new FactorialTrailingZeroes_172();
        System.out.println(ft.fun(10));
        System.out.println(ft.trailingZeroes(10));
    }
}