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
        int res = 2;
        Set<Double> set = new HashSet<>();
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (!set.contains((double) (j) / i)) {
                    res++;
                    set.add((double) (j) / i);
                }

            }
        }
        System.out.println(res);
    }
}