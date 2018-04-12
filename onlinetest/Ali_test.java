package com.cxj.onlinetest;


import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Ali_test {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();

        if (N == 0) {
            System.out.println(0);
            return;
        }
        if (N == 1) {
            System.out.println(3);
            return;
        }
        int res = 0;
        Set<Double> set = new HashSet<>();
        set.add((double) 1 / 1);
        System.out.println(set);

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
//                根据对称性质 只计算一半的矩阵就行了
                if ((double) i / j > 1.0) {
                    if (!set.contains((double) (j) / i)) {
                        res++;
                        set.add((double) (j) / i);
                    }
                }

            }
        }

        System.out.println(res * 2 + 3);
    }
}