package com.cxj.onlinetest;

import java.util.Scanner;

/**
 * a,b表示当前电量，aMax，bMAx代表容量，step表示步数
 */
public class Toutiao_5 {
    public static void doSth(int a, int aMax, int b, int bMax, int step, int c) {
        if (a == c || b == c || (c > aMax && c > bMax))
            return;
        //a和b的状态算上0的话一共有（aMax+1）*（bMAx+1）种，这个为退出条件
        if (step >= (aMax + 1) * (bMax + 1))
            return;
        //a放电
        if (a > 0)
            doSth(0, aMax, b, bMax, step + 1, c);
        //b放电
        if (b > 0)
            doSth(a, aMax, 0, bMax, step + 1, c);
        //a充满
        if (a < aMax)
            doSth(aMax, aMax, b, bMax, step + 1, c);
        //b充满
        if (b < bMax)
            doSth(a, aMax, bMax, bMax, step + 1, c);
        //a转移到b且b能充满a有剩余
        if (b < bMax && a > 0 && a >= (bMax - b))
            doSth(a + b - bMax, aMax, bMax, bMax, step + 1, c);
        //a转移到b且b充不满没有剩余
        if (b < bMax && a > 0 && a < (bMax - b))
            doSth(0, aMax, a + b, bMax, step + 1, c);
        //b转移到a且a能充满有剩余
        if (a < aMax && b > 0 && b >= (aMax - a))
            doSth(aMax, aMax, b + a - aMax, bMax, step + 1, c);
        //b转移到a且a充不满没有剩余
        if (a < aMax && b > 0 && b < (aMax - a))
            doSth(a + b, aMax, 0, bMax, step + 1, c);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n <= 0 || n >= 100)
            return;
        int[] array = new int[3];
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                int x = sc.nextInt();
                array[j] = x;
            }
            int aMax = array[0];
            int bMax = array[1];
            int step = 1;
            doSth(array[0], aMax, array[1], bMax, step, array[2]);
        }
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}