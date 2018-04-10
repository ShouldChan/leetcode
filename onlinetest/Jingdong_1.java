package com.cxj.onlinetest;

import java.util.Scanner;

/**
 * 问题描述：求N=X*Y，一个数可由一个奇数和一个偶数相乘得到。
 * 输入：
 * 第一行输入一个数t 表示需要判断的数的个数（表示之后输入的行数个数）
 * 第2至t+1行 每行输入的数表示N
 */

public class Jingdong_1 {
    public static String getValue(long n) {
        if (n % 2 == 1)
            return "No";
        for (int i = 2; i < n / 2; i += 2) {
            // i是偶数  n/i是不是奇数 n能否被i整除
            if (n % i == 0 && (n / i) % 2 == 1)
                return n / i + " " + i;
        }
        return "No";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        String[] array = new String[t];
        for (int i = 0; i < t; i++) {
            long x = sc.nextLong();
            array[i] = getValue(x);
        }
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}