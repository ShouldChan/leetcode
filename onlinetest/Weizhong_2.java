package com.cxj.onlinetest;

import java.util.Scanner;

public class Weizhong_2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        int count = 0;
        long tmp = n;
        String s = Long.toBinaryString(tmp);
        //System.out.println(s);
        int num = s.length();
        int[] dp = new int[num + 1];
        int res = 1;
        dp[0] = 0;
        dp[1] = 2;
        dp[2] = 2;
        for (int i = 3; i <= num; i++) {
            dp[i] = 2 + dp[i - 2];
        }
        if (num > 1) {
            res++;
        }
        if (num > 2) {
            res++;
        }
        for (int i = 3; i < num; i++) res += dp[i - 2];
//        int res = dp[num - 1 - 2] + 1;
        long i = (long) Math.pow(2.0, num - 1);
        for (; i <= n; i++) {
            if (isPal(Long.toBinaryString(i))) res++;
        }
        System.out.println(res);
    }

    private static boolean isPal(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {

            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;

        }
        return true;
    }
}