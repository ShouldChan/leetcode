package com.cxj.swordoffer;

public class Fibonacci {
    public int recur_Fibonacci(int n) {
        if (n <= 0)
            return 0;
        if (n == 1 || n == 2)
            return 1;

        return recur_Fibonacci(n - 1) + recur_Fibonacci(n - 2);


    }

    public static void main(String[] args) {
        int n = 10;
        Fibonacci fb = new Fibonacci();
        int result = fb.recur_Fibonacci(n);
        System.out.println(result);
    }
}