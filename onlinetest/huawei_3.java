package com.cxj.onlinetest;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class huawei_3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Integer> flows = new ArrayList<>();
        List<Integer> golds = new ArrayList<>();
        flows.add(0);
        golds.add(0);
        int m = Integer.parseInt(in.nextLine());
        String[] split = in.nextLine().split(" ");
        int n = split.length;
        int[] w = new int[n + 1];
        int[] v = new int[n + 1];
        for (int i = 0; i < n; i++) {
            w[i + 1] = Integer.parseInt(split[i]);
        }
        split = in.nextLine().split(" ");
        for (int i = 0; i < n; i++) {
            v[i + 1] = Integer.parseInt(split[i]);
        }
        knapsackOptimal(m, n, w, v);
    }

    public static void knapsackOptimal(int c, int n, int[] w, int[] v) {

        int[][] G = new int[n + 1][c + 1];

        int[] values = new int[c + 1];

        for (int i = 1; i < n + 1; i++) {
            for (int t = c; t >= w[i]; t--) {
                if (values[t] < values[t - w[i]] + v[i]) {
                    values[t] = values[t - w[i]] + v[i];
                    G[i][t] = 1;
                }
            }
        }

        StringBuilder result = new StringBuilder();
        int i = n;
        int j = c;
        while (i > 0) {
            if (G[i][j] == 1) {
                result.insert(0, i + " ");
                j -= w[i];
            }
            i--;
        }
        System.out.println(result.toString().trim());
    }
}