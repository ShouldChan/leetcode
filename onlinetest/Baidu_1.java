package com.cxj.onlinetest;

/**
 * 没做出来
 */

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * 题目描述
 * n个国家 ，每个国家有5个运动员 要求每个运动员都与自己的一个同胞相邻
 * 求满足条件的方案数
 * input:
 * 1
 * output:
 * 120
 * input2:
 * 3
 * output3:
 * 736128000
 */
public class Baidu_1 {
    public static long getN(int n) {
        long result = 1;
        for (int i = n; i >= 1; i--) {
            result *= i;
        }
        return result;
    }

    public static String show(int n) {
        BigDecimal last = new BigDecimal(1);//BigDecimal 进行高精度计算
        for (int i = n + 1; i <= 2 * n; i++) {
            last = last.multiply(new BigDecimal(i));
        }
        BigDecimal last1 = new BigDecimal(1);
        for (int i = 1; i <= n; i++) {
            last1 = last1.multiply(new BigDecimal(i));
        }
        last = last.multiply(last1);
//        last.subtract(last1)   last-last1
//        divideAndRemainder(100000007) 对100000007取余  数非常大
        BigDecimal[] result = last.subtract(last1).multiply(new BigDecimal(120)).divideAndRemainder(new BigDecimal(1000000007));
        return result[1].toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(show(n));
    }
}