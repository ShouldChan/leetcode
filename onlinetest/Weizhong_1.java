package com.cxj.onlinetest;

import java.util.Scanner;

/**
 * 输入a>b>c，求2^a+2^b-2^c的二进制中有多少个1
 * 2^a的二进制只有一位为1
 * 2^b-2^c
 * eg：   1000
 *      - 0010
 *      --------
 *        0110
 * 1的个数为1+（4-2）=3
 *          （b+1-(c+1)）=b-c+1
 */
public class Weizhong_1 {
    public static int getBin1(int a, int b, int c) {
        return b - c + 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        System.out.println(getBin1(a, b, c));
    }
}