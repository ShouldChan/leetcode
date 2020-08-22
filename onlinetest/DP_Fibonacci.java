package com.cxj.onlinetest;


public class DP_Fibonacci {
    //递归实现Fibonacci
    public int recurrentFibo(int n) {
        if (n == 0 || n == 1)
            return 1;
        else {
            System.out.println(n);
            return recurrentFibo(n - 2) + recurrentFibo(n - 1);
        }


    }

    //DP Fibonacci
    //use space(JiebiArray) to save the temporal variance
    public int dpFibo(int n) {
        n = n + 1;
        int[] array = new int[n];
        array[0] = 1;
        array[1] = 1;
        for (int i = 2; i < n; i++) {
            array[i] = array[i - 2] + array[i - 1];
        }
        return array[n - 1];
    }

    public static void main(String[] args) {
        DP_Fibonacci dpf = new DP_Fibonacci();
        //Recurrent
        long t1 = System.currentTimeMillis();
        int n = 10;
        int result1 = dpf.recurrentFibo(n);
        long t2 = System.currentTimeMillis();
        System.out.println(result1);
        System.out.println("Time cost:\t" + (t2 - t1));

        //DP
        long t3 = System.currentTimeMillis();
        int result2 = dpf.dpFibo(10);
        long t4 = System.currentTimeMillis();
        System.out.println(result2);
        System.out.println("Time cost:\t" + (t4 - t3));

    }
}